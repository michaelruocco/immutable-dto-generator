package uk.co.mruoc.code;

public class AssignBigDecimalVariableDefinition implements StatementDefinition {

    private final FieldDefinition field;

    AssignBigDecimalVariableDefinition(FieldDefinition field) {
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "$T $N = $T.valueOf($L)";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] {
                field.getType(),
                field.getName(),
                field.getType(),
                10 };
    }

}
