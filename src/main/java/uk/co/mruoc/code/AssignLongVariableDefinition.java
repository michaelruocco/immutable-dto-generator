package uk.co.mruoc.code;

public class AssignLongVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "L";

    public AssignLongVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
