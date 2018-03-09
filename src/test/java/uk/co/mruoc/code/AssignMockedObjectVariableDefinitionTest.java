package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignMockedObjectVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "Object");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignMockedObjectVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $T.mock($T.class)");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName valueClassName = ClassName.bestGuess("Object");
        assertThat(definition.getArgs()).contains(valueClassName, "value", Mockito.class, valueClassName);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("Object value = org.mockito.Mockito.mock(Object.class);");
    }

}
