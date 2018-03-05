package uk.co.mruoc.code;

public class AssignDoubleVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "D";

    public AssignDoubleVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
