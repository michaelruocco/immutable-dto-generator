package uk.co.mruoc.code;

public class AssignNumericVariableWithSuffixDefinition implements StatementDefinition {

    private final FieldDefinition field;
    private final String suffix;

    AssignNumericVariableWithSuffixDefinition(FieldDefinition field, String suffix) {
        this.field = field;
        this.suffix = suffix;
    }

    @Override
    public String getFormat() {
        String format = "$T $N = $L";
        if (field.isPrimitive()) {
            return format;
        }
        return format + suffix;
    }

    @Override
    public Object[] getArgs() {
        return new Object[] { field.getType(), field.getName(), 10 };
    }

}
