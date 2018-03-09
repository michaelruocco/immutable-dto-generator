package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignObjectDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "Object");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignObjectVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = new $T()");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName objectClass = ClassName.bestGuess("Object");
        assertThat(definition.getArgs()).contains(objectClass, "value", objectClass);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("Object value = new Object();");
    }

}
