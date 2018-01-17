package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;

public class AssertVariableDefinitionFactory {

    private final ClassName dtoClassName;

    public AssertVariableDefinitionFactory(ClassName dtoClassName) {
        this.dtoClassName = dtoClassName;
    }

    public StatementDefinition get(FieldDefinition field) {
        if (field.hasType(boolean.class)) {
            return new AssertBooleanVariableDefinition(dtoClassName, field);
        }
        return new AssertVariableDefinition(dtoClassName, field);
    }

}
