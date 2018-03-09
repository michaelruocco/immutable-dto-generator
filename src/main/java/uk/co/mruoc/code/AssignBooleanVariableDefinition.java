package uk.co.mruoc.code;

import java.util.Random;

public class AssignBooleanVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignBooleanVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = new $T().nextBoolean()";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), Random.class };
    }

}
