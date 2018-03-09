package uk.co.mruoc.code;

class AssignLongVariableDefinition extends AssignNumericVariableWithSuffixDefinition {

    private static final String SUFFIX = "L";

    AssignLongVariableDefinition(FieldDefinition field) {
        super(field, SUFFIX);
    }

}
