package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;

public class FieldDefinition {

    private final String name;
    private final FieldType fieldType;

    public FieldDefinition(String name, String typeString) {
        this(name, StringToTypeNameConverter.toTypeName(typeString));
    }

    public FieldDefinition(String name, Class<?> type) {
        this(name, type.getTypeName());
    }

    public FieldDefinition(String name, TypeName type) {
        this.name = name;
        this.fieldType = new FieldType(type);
    }

    public String getName() {
        return name;
    }

    public TypeName getType() {
        return fieldType.getType();
    }

    public TypeName getInstanceType() {
        return fieldType.getInstanceType();
    }

    public boolean isString() {
        return fieldType.isString();
    }

    public boolean isBigDecimal() {
        return fieldType.isBigDecimal();
    }

    public boolean isDate() {
        return fieldType.isDate();
    }

    public boolean isLocalDate() {
        return fieldType.isLocalDate();
    }

    public boolean isLocalDateTime() {
        return fieldType.isLocalDateTime();
    }

    public boolean isBoolean() {
        return fieldType.isBoolean();
    }

    public boolean isInt() {
        return fieldType.isInt();
    }

    public boolean isLong() {
        return fieldType.isLong();
    }

    public boolean isFloat() {
        return fieldType.isFloat();
    }

    public boolean isDouble() {
        return fieldType.isDouble();
    }

    public boolean isShort() {
        return fieldType.isShort();
    }

    public boolean isByte() {
        return fieldType.isByte();
    }

    public boolean isChar() {
        return fieldType.isChar();
    }

    public boolean isPrimitive() {
        return fieldType.isPrimitive();
    }

    public boolean instanceTypeHasPublicNoArgumentConstructor() {
        return fieldType.instanceTypeHasPublicNoArgumentConstructor();
    }

    public boolean isGenericCollection() {
        return fieldType.isGenericCollection();
    }

}
