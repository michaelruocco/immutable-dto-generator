package uk.co.mruoc.code;

import java.lang.reflect.Type;

public class FieldDefinition {

    private final String name;
    private final Type type;

    public FieldDefinition(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean hasType(Type otherType) {
        return type.getTypeName().equals(otherType.getTypeName());
    }

}
