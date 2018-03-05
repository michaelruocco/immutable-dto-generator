package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

//import java.lang.reflect.Type;
//import java.util.stream.Stream;

public class FieldDefinition {

    private static final ClassName BIG_DECIMAL = ClassName.get("java.math", "BigDecimal");
    private static final ClassName STRING = ClassName.get("java.lang", "String");
    private static final ClassName LOCAL_DATE = ClassName.get("java.time", "LocalDate");
    private static final ClassName LOCAL_DATE_TIME = ClassName.get("java.time", "LocalDateTime");

    private final String name;
    private final TypeName type;

    public FieldDefinition(String name, Class<?> type) {
        this(name, type.getTypeName());
    }

    public FieldDefinition(String name, String typeString) {
        this(name, StringToTypeNameConverter.toTypeName(typeString));
    }

    public FieldDefinition(String name, TypeName type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TypeName getType() {
        return type;
    }

    public boolean isString() {
        return hasType(STRING);
    }

    public boolean isBigDecimal() {
        return hasType(BIG_DECIMAL);
    }

    public boolean isLocalDate() {
        return hasType(LOCAL_DATE);
    }

    public boolean isLocalDateTime() {
        return hasType(LOCAL_DATE_TIME);
    }

    public boolean isBoolean() {
        return hasPrimitiveType(TypeName.BOOLEAN);
    }

    public boolean isInt() {
        return hasPrimitiveType(TypeName.INT);
    }

    public boolean isLong() {
        return hasPrimitiveType(TypeName.LONG);
    }

    public boolean isFloat() {
        return hasPrimitiveType(TypeName.FLOAT);
    }

    public boolean isDouble() {
        return hasPrimitiveType(TypeName.DOUBLE);
    }

    public boolean isShort() {
        return hasPrimitiveType(TypeName.SHORT);
    }

    public boolean isByte() {
        return hasPrimitiveType(TypeName.BYTE);
    }

    public boolean isChar() {
        return hasPrimitiveType(TypeName.CHAR);
    }

    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    private boolean hasType(TypeName otherType) {
        return otherType.toString().equals(type.toString());
    }

    private boolean hasPrimitiveType(TypeName otherType) {
        return hasType(otherType) || hasType(otherType.box());
    }

    //public boolean typeHasPublicNoArgumentConstructor() {
    //    return Stream.of(type.getConstructors()).anyMatch((c) -> c.getParameterCount() == 0);
    //}

}
