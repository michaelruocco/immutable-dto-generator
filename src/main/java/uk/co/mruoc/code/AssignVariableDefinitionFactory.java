package uk.co.mruoc.code;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AssignVariableDefinitionFactory {

    public StatementDefinition get(FieldDefinition field) {
        if (field.hasType(BigDecimal.class)) {
            return new AssignBigDecimalVariableDefinition(field);

        } else if (field.hasType(int.class) || field.hasType(Integer.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(long.class) || field.hasType(Long.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(float.class) || field.hasType(Float.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(double.class) || field.hasType(Double.class)) {
            return new AssignNumericVariableDefinition(field);

        } else if (field.hasType(LocalDate.class)) {
            return new AssignLocalDateVariableDefinition(field);

        } else if (field.hasType(boolean.class)) {
            return new AssignBooleanStatementDefinition(field);

        }

        return new AssignStringVariableDefinition(field);
    }

}
