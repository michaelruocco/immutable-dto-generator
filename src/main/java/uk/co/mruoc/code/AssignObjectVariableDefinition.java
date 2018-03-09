package uk.co.mruoc.code;

public class AssignObjectVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignObjectVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        if (field.isGenericCollection()) {
            return "$T $N = new $T<>()";
        }
        return "$T $N = new $T()";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), field.getInstanceType() };
    }

}
