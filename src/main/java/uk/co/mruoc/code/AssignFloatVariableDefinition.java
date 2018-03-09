package uk.co.mruoc.code;

class AssignFloatVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "F";

    AssignFloatVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
