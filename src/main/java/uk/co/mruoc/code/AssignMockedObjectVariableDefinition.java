package uk.co.mruoc.code;

import org.mockito.Mockito;

public class AssignMockedObjectVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignMockedObjectVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $T.mock($T.class)";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), Mockito.class, field.getType() };
    }

}
