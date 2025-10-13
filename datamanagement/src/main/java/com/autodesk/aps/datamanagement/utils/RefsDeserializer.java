package com.autodesk.aps.datamanagement.utils;

import java.io.IOException;
import java.util.List;

import com.autodesk.aps.datamanagement.model.JsonApiLinksSelf;
import com.autodesk.aps.datamanagement.model.Refs;
import com.autodesk.aps.datamanagement.model.RefsData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RefsDeserializer extends JsonDeserializer<Refs> {

    @JsonDeserialize(using = JsonDeserializer.None.class)
    public static interface NoCustomDeserializerMixIn {
    }

    private static final ObjectMapper CLEAN_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public Refs deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        Refs refs = new Refs();

        if (root.has("jsonapi")) {
            refs.setJsonapi(CLEAN_MAPPER.treeToValue(root.get("jsonapi"),
                    com.autodesk.aps.datamanagement.model.JsonApiVersion.class));
        }

        if (root.has("links")) {
            JsonNode linksNode = root.get("links");
            if (linksNode.has("self")) {
                JsonApiLinksSelf links = new JsonApiLinksSelf();
                links.setSelf(CLEAN_MAPPER.treeToValue(linksNode.get("self"),
                        com.autodesk.aps.datamanagement.model.JsonApiLinksSelfSelf.class));
                refs.setLinks(links);
            }
        }

        if (root.has("data")) {
            refs.setData(CLEAN_MAPPER.readValue(root.get("data").toString(),
                    new TypeReference<List<RefsData>>() {
                    }));
        }

        return refs;
    }
}