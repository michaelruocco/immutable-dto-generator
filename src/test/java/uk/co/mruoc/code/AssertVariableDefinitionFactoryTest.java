package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertVariableDefinitionFactoryTest {

    private final ClassName dtoClassName = ClassName.bestGuess("MyClass");


    private final AssertVariableDefinitionFactory factory = new AssertVariableDefinitionFactory(dtoClassName);

    @Test
    public void shouldCreateAssertBooleanVariableStatementDefinition() {
        FieldDefinition field = new FieldDefinition("variable", "boolean");

        StatementDefinition statement = factory.get(field);

        assertThat(statement.getClass()).isEqualTo(AssertBooleanVariableDefinition.class);
    }

    @Test
    public void shouldCreateAssertVariableStatementDefinition() {
        FieldDefinition field = new FieldDefinition("variable", "Object");

        StatementDefinition statement = factory.get(field);

        assertThat(statement.getClass()).isEqualTo(AssertVariableDefinition.class);
    }

}
