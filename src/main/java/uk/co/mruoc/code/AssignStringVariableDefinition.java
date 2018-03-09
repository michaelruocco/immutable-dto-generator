package uk.co.mruoc.code;

public class AssignStringVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignStringVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $S";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), field.getName() };
    }

}
