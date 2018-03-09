package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignLongVariableDefinitionTest {

    private final StatementBuilder builder = new StatementBuilder();

    @Test
    public void shouldReturnFormat() {
        FieldDefinition field = new FieldDefinition("value", "long");

        StatementDefinition definition = new AssignLongVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $L");
    }

    @Test
    public void shouldReturnObjectFormat() {
        FieldDefinition field = new FieldDefinition("value", "Long");

        StatementDefinition definition = new AssignLongVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $LL");
    }

    @Test
    public void shouldReturnArguments() {
        String type = "java.lang.Long";
        FieldDefinition field = new FieldDefinition("value", type);

        StatementDefinition definition = new AssignLongVariableDefinition(field);

        assertThat(definition.getArgs()).contains(ClassName.bestGuess(type), "value", 10);
    }

    @Test
    public void shouldBuildStatement() {
        FieldDefinition field = new FieldDefinition("value", "Long");

        StatementDefinition definition = new AssignLongVariableDefinition(field);

        assertThat(builder.toStatement(definition)).isEqualTo("Long value = 10L;");
    }

}
