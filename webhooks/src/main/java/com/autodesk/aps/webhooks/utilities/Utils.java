package com.autodesk.aps.webhooks.utilities;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;

public class Utils {
    /**
     * Gets the string value of an enum by looking for the JsonValue annotation.
     * Similar to C#'s EnumMemberAttribute functionality.
     * 
     * @param <T>       The enum type
     * @param enumValue The enum value to get the string for
     * @return The string value from the JsonValue annotation, or the enum's
     *         toString() if not found
     */
    public static <T extends Enum<T>> String getEnumString(T enumValue) {
        if (enumValue == null) {
            return null;
        }

        try {
            Field field = enumValue.getClass().getField(enumValue.name());
            JsonValue annotation = field.getAnnotation(JsonValue.class);

            // If there's no annotation, just return the enum's toString value
            if (annotation == null) {
                return enumValue.toString();
            }

            // Get the value from the field if it has the JsonValue annotation
            Object value = field.get(enumValue);
            return value != null ? value.toString() : enumValue.toString();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            return enumValue.toString();
        }
    }
}
