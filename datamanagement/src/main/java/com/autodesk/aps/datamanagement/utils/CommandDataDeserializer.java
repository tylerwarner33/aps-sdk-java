package com.autodesk.aps.datamanagement.utils;

import java.io.IOException;

import com.autodesk.aps.datamanagement.model.CheckPermission;
import com.autodesk.aps.datamanagement.model.CommandData;
import com.autodesk.aps.datamanagement.model.ListItems;
import com.autodesk.aps.datamanagement.model.ListRefs;
import com.autodesk.aps.datamanagement.model.PublishModel;
import com.autodesk.aps.datamanagement.model.PublishModelJob;
import com.autodesk.aps.datamanagement.model.PublishWithoutLinks;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CommandDataDeserializer extends JsonDeserializer<CommandData> {

    @JsonDeserialize(using = JsonDeserializer.None.class)
    public static interface NoCustomDeserializerMixIn {
    }

    private static final ObjectMapper CLEAN_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Override
    public CommandData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        JsonNode attributes = root.get("attributes");
        if (attributes != null) {
            JsonNode extension = attributes.get("extension");
            if (extension != null) {
                JsonNode typeNode = extension.get("type");
                System.out.println("typeNode: " + typeNode);
                if (typeNode != null) {
                    String type = typeNode.asText();
                    
                    CLEAN_MAPPER.addMixIn(CommandData.class, NoCustomDeserializerMixIn.class);
                    if ("commands:autodesk.core:CheckPermission".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), CheckPermission.class);
                    } else if ("commands:autodesk.bim360:C4RPublishWithoutLinks".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), PublishWithoutLinks.class);
                    } else if ("commands:autodesk.core:ListItems".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), ListItems.class);
                    } else if ("commands:autodesk.core:ListRefs".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), ListRefs.class);
                    } else if ("commands:autodesk.bim360:C4RModelPublish".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), PublishModel.class);
                    } else if ("commands:autodesk.bim360:C4RModelGetPublishJob".equals(type)) {
                        return CLEAN_MAPPER.readValue(root.toString(), PublishModelJob.class);
                    }
                }
            }
        }
        throw new IllegalArgumentException("Unknown or missing attributes.extension.type in CommandData");
    }
}