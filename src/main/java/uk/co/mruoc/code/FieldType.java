package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import java.util.stream.Stream;

import static uk.co.mruoc.code.CollectionsConverter.*;

public class FieldType {

    private static final ClassName BIG_DECIMAL = ClassName.get("java.math", "BigDecimal");
    private static final ClassName STRING = ClassName.get("java.lang", "String");
    private static final ClassName LOCAL_DATE = ClassName.get("java.time", "LocalDate");
    private static final ClassName LOCAL_DATE_TIME = ClassName.get("java.time", "LocalDateTime");
    private static final TypeName DATE = ClassName.get("java.util", "Date");

    private final TypeName type;

    FieldType(TypeName type) {
        this.type = type;
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

    public boolean isDate() {
        return hasType(DATE);
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

    public TypeName getInstanceType() {
        return ClassName.bestGuess(toImplementation(type.toString()));
    }

    public boolean instanceTypeHasPublicNoArgumentConstructor() {
        try {
            String className = toImplementation(type.toString());
            Class<?> clazz = Class.forName(className);
            return Stream.of(clazz.getConstructors()).anyMatch((c) -> c.getParameterCount() == 0);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(type.toString(), e);
        }
    }

    public boolean isGenericCollection() {
        return CollectionsConverter.isCollectionInterface(type.toString());
    }

    private boolean hasType(TypeName otherType) {
        return otherType.toString().equals(type.toString());
    }

    private boolean hasPrimitiveType(TypeName otherType) {
        return hasType(otherType) || hasType(otherType.box());
    }

}
