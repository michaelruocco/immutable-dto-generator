package uk.co.mruoc.code;

public class AssignCharVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignCharVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = '$L'";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), 'a' };
    }

}
