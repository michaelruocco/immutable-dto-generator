package uk.co.mruoc.code;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class GetterMethodNameBuilder {

    public String build(FieldDefinition field) {
        String name = capitalize(field.getName());
        //if (field.hasType(Boolean.class) || field.hasType(boolean.class)) {
        if (field.isBoolean()) {
            return "is" + name;
        }
        return "get" + name;
    }

}
