package com.autodesk.aps.datamanagement.utils;

import java.io.IOException;

import com.autodesk.aps.datamanagement.model.FolderData;
import com.autodesk.aps.datamanagement.model.ItemData;
import com.autodesk.aps.datamanagement.model.RefsData;
import com.autodesk.aps.datamanagement.model.VersionData;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RefsDataDeserializer extends JsonDeserializer<RefsData> {

    @JsonDeserialize(using = JsonDeserializer.None.class)
    public static interface NoCustomDeserializerMixIn {
    }

    private static final ObjectMapper CLEAN_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public RefsData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        JsonNode typeNode = root.get("type");
        if (typeNode != null) {
            String type = typeNode.asText();

            CLEAN_MAPPER.addMixIn(RefsData.class, NoCustomDeserializerMixIn.class);

            if ("folders".equals(type)) {
                return CLEAN_MAPPER.readValue(root.toString(), FolderData.class);
            } else if ("items".equals(type)) {
                return CLEAN_MAPPER.readValue(root.toString(), ItemData.class);
            } else if ("versions".equals(type)) {
                return CLEAN_MAPPER.readValue(root.toString(), VersionData.class);
            }
        }
        throw new IllegalArgumentException("Unknown or missing type in RefsData");
    }
}