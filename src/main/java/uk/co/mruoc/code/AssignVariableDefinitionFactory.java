package uk.co.mruoc.code;

public class AssignVariableDefinitionFactory {

    public StatementDefinition get(FieldDefinition field) {
        if (field.isString()) {
            return new AssignStringVariableDefinition(field);

        } else if (field.isBigDecimal()) {
            return new AssignBigDecimalVariableDefinition(field);

        } else if (field.isInt()) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.isLong()) {
            return new AssignLongVariableDefinition(field);

        } else if (field.isFloat()) {
            return new AssignFloatVariableDefinition(field);

        } else if (field.isDouble()) {
            return new AssignDoubleVariableDefinition(field);

        } else if (field.isShort()) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.isByte()) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.isBoolean()) {
            return new AssignBooleanStatementDefinition(field);

        } else if (field.isChar()) {
            return new AssignCharVariableDefinition(field);

        } else if (field.isLocalDate()) {
            return new AssignLocalDateVariableDefinition(field);

        } else if (field.isLocalDateTime()) {
            return new AssignLocalDateTimeVariableDefinition(field);
        }

        return new AssignMockedObjectVariableDefinition(field);
    }

}
