package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;

public class AssertVariableDefinitionFactory {

    private final ClassName dtoClassName;

    AssertVariableDefinitionFactory(ClassName dtoClassName) {
        this.dtoClassName = dtoClassName;
    }

    public StatementDefinition get(FieldDefinition field) {
        if (field.isBoolean()) {
            return new AssertBooleanVariableDefinition(dtoClassName, field);
        }
        return new AssertVariableDefinition(dtoClassName, field);
    }

}
