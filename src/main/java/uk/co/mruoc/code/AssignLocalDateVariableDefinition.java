package uk.co.mruoc.code;

public class AssignLocalDateVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignLocalDateVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $T.of($L, $L, $L)";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] {
                field.getType(),
                field.getName(),
                field.getType(),
                2018,
                1,
                1
        };
    }

}
