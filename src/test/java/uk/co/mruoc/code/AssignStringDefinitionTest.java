package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignStringDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "String");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignStringVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $S");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName objectClass = ClassName.bestGuess("String");
        assertThat(definition.getArgs()).contains(objectClass, "value", "value");
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("String value = \"value\";");
    }

}
