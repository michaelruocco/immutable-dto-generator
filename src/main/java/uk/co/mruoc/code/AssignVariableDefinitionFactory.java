package uk.co.mruoc.code;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AssignVariableDefinitionFactory {

    public StatementDefinition get(FieldDefinition field) {
        if (field.hasType(String.class)) {
            return new AssignStringVariableDefinition(field);

        } else if (field.hasType(BigDecimal.class)) {
            return new AssignBigDecimalVariableDefinition(field);

        } else if (field.hasType(int.class) || field.hasType(Integer.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(long.class) || field.hasType(Long.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(float.class) || field.hasType(Float.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(double.class) || field.hasType(Double.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(short.class) || field.hasType(Short.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(byte.class) || field.hasType(Byte.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(boolean.class) || field.hasType(Boolean.class)) {
            return new AssignBooleanStatementDefinition(field);

        } else if (field.hasType(char.class) || field.hasType(Character.class)) {
            return new AssignCharVariableDefinition(field);

        } else if (field.hasType(LocalDate.class)) {
            return new AssignLocalDateVariableDefinition(field);

        } else if (field.hasType(LocalDateTime.class)) {
            return new AssignLocalDateTimeVariableDefinition(field);

        }

        return new AssignObjectVariableDefinition(field);
    }

}
