package com.autodesk.aps.datamanagement.utils;

import java.io.IOException;

import com.autodesk.aps.datamanagement.model.JsonApiLinksRelated;
import com.autodesk.aps.datamanagement.model.JsonApiLinksSelf;
import com.autodesk.aps.datamanagement.model.RelationshipRefsLinks;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RelationshipRefsLinksDeserializer extends JsonDeserializer<RelationshipRefsLinks> {

    @JsonDeserialize(using = JsonDeserializer.None.class)
    public static interface NoCustomDeserializerMixIn {
    }

    private static final ObjectMapper CLEAN_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public RelationshipRefsLinks deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        if (root.has("related")) {

            CLEAN_MAPPER.addMixIn(RelationshipRefsLinks.class, NoCustomDeserializerMixIn.class);
            return CLEAN_MAPPER.readValue(root.toString(), JsonApiLinksRelated.class);
        } else if (root.has("self")) {

            CLEAN_MAPPER.addMixIn(RelationshipRefsLinks.class, NoCustomDeserializerMixIn.class);
            return CLEAN_MAPPER.readValue(root.toString(), JsonApiLinksSelf.class);
        }

        throw new IllegalArgumentException("Unknown or missing fields in RelationshipRefsLinks");
    }
}
