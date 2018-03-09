package uk.co.mruoc.code;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class GetterMethodNameBuilder {

    public static String build(FieldDefinition field) {
        String name = capitalize(field.getName());
        if (field.isBoolean()) {
            return "is" + name;
        }
        return "get" + name;
    }

}
