package uk.co.mruoc.code;

public class AssignFloatVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "F";

    public AssignFloatVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
