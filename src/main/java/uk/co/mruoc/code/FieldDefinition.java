package uk.co.mruoc.code;

import java.lang.reflect.Type;
import java.util.stream.Stream;

public class FieldDefinition {

    private final String name;
    private final Class<?> type;

    public FieldDefinition(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return type;
    }

    public boolean hasType(Type otherType) {
        return type.getTypeName().equals(otherType.getTypeName());
    }

    public boolean typeHasPublicNoArgumentConstructor() {
        return Stream.of(type.getConstructors()).anyMatch((c) -> c.getParameterCount() == 0);
    }

}
