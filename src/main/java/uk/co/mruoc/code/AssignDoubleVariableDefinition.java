package uk.co.mruoc.code;

class AssignDoubleVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "D";

    AssignDoubleVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
