package com.autodesk.aps.sdkmanager;

import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.*;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.timelimiter.TimeLimiter;

public class ApsService implements AutoCloseable {
    private final IApsLogger logger;
    private final ObjectMapper objectMapper;
    private final Retry retry;
    private final CircuitBreaker circuitBreaker;
    private final TimeLimiter timeLimiter;
    private final ThreadPoolBulkhead bulkhead;
    private final CloseableHttpClient httpClient;
    private final ScheduledExecutorService scheduler;

    public ApsService(IResiliencyConfiguration config, IApsLogger logger) {
        this.logger = logger;
        this.objectMapper = new ObjectMapper();
        this.retry = Retry.of("apsRetry", config.getRetryConfig());
        this.circuitBreaker = CircuitBreaker.of("apsCircuitBreaker", config.getCircuitBreakerConfig());
        this.timeLimiter = TimeLimiter.of(Duration.ofMillis(config.getTimeLimiterTimeoutMillis()));
        this.httpClient = HttpClients.createDefault();
        this.scheduler = Executors.newScheduledThreadPool(1);
        bulkhead = ThreadPoolBulkhead.of("apsBulkhead", config.getBulkheadConfig());

    }

    public ClassicHttpResponse request(ApsServiceRequestConfig config) throws InterruptedException, ExecutionException {
        if (config == null) {
            throw new IllegalArgumentException("Request config must not be null");
        }
        final HttpUriRequest request;
        try {
            request = createRequest(config);
        } catch (Exception e) {
            throw new RuntimeException("Request creation failed", e);
        }

        Supplier<ClassicHttpResponse> supplier = () -> {
            try {
                return httpClient.executeOpen(null, request, null);
            } catch (IOException e) {
                throw new RuntimeException("HTTP request failed", e);
            }

        };
        return execute(supplier);
    }

    private <T> T execute(Supplier<T> supplier) {
        try {
            CompletableFuture<T> result = Decorators.ofSupplier(supplier)
                    .withThreadPoolBulkhead(bulkhead)
                    .withTimeLimiter(timeLimiter, scheduler)
                    .withCircuitBreaker(circuitBreaker)
                    .withRetry(retry, scheduler)
                    .get().toCompletableFuture();
            return result.get();
        } catch (Exception e) {
            throw new RuntimeException("Request failed", e);
        }
    }

    private HttpUriRequest createRequest(ApsServiceRequestConfig config) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(config.getUrl());
        config.getQueryParams().forEach(uriBuilder::setParameter);

        HttpUriRequest request = createBaseRequest(config.getMethod(), uriBuilder.build());

        // Add all headers first
        config.getHeaders().forEach(request::addHeader);
        // Determine content type
        String contentType = Optional.ofNullable(request.getFirstHeader("Content-Type"))
                .map(Header::getValue)
                .orElse("application/json");

        // Set default content type if missing
        if (!request.containsHeader("Content-Type")) {
            request.addHeader("Content-Type", contentType);
        }

        // Handle request body for entity-enclosing methods
        if (request instanceof HttpUriRequestBase && config.getBody() != null) {
            HttpEntity entity = createEntity(contentType, config.getBody());
            ((HttpUriRequestBase) request).setEntity(entity);
        }
        return request;
    }

    private HttpUriRequest createBaseRequest(String method, URI uri) {
        switch (method.toUpperCase()) {
            case "GET":
                return new HttpGet(uri);
            case "POST":
                return new HttpPost(uri);
            case "PUT":
                return new HttpPut(uri);
            case "PATCH":
                return new HttpPatch(uri);
            case "DELETE":
                return new HttpDelete(uri);
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }

    private HttpEntity createEntity(String contentType, Object body) throws IOException {
        ContentType parsedType = ContentType.parse(contentType);
        String mimeType = parsedType.getMimeType();
        try {
            return switch (mimeType) {
                case "application/json", "application/vnd.api+json" -> new StringEntity(
                        objectMapper.writeValueAsString(body),
                        parsedType);

                case "application/x-www-form-urlencoded" -> {
                    if (body instanceof Map) {
                        List<NameValuePair> params = new ArrayList<>();
                        ((Map<?, ?>) body)
                                .forEach((k, v) -> params.add(new BasicNameValuePair(k.toString(), v.toString())));
                        yield new UrlEncodedFormEntity(params, parsedType.getCharset());
                    }
                    throw new IllegalArgumentException("Form-urlencoded requires Map body");
                }

                case "text/plain" -> new StringEntity(
                        body.toString(),
                        ContentType.TEXT_PLAIN);

                default -> {
                    if (body instanceof HttpEntity) {
                        yield (HttpEntity) body;
                    }
                    if (body instanceof byte[]) {
                        yield new ByteArrayEntity((byte[]) body, parsedType);
                    }
                    String stringifiedBody = (body instanceof String)
                            ? (String) body
                            : objectMapper.writeValueAsString(body);
                    yield new StringEntity(stringifiedBody, parsedType);
                }
            };
        } catch (Exception ex) {
            logger.error("Failed to create HTTP entity for content type: " + contentType, ex);
            throw new RuntimeException("Failed to create HTTP entity for content type: " + contentType, ex);
        }
    }

    @Override
    public void close() throws Exception {
        httpClient.close();
        scheduler.shutdown();
        bulkhead.close();
        if (!scheduler.awaitTermination(10, TimeUnit.SECONDS)) {
            scheduler.shutdownNow();
        }
    }
}