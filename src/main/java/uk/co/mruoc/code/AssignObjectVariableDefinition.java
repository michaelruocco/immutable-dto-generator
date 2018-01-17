package uk.co.mruoc.code;

public class AssignObjectVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    public AssignObjectVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = new $T()";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), field.getType() };
    }

}
