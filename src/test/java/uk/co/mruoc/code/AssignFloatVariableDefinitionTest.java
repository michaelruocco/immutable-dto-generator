package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignFloatVariableDefinitionTest {

    private final StatementBuilder builder = new StatementBuilder();

    @Test
    public void shouldReturnFormat() {
        FieldDefinition field = new FieldDefinition("value", "float");

        StatementDefinition definition = new AssignFloatVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $L");
    }

    @Test
    public void shouldReturnObjectFormat() {
        FieldDefinition field = new FieldDefinition("value", "Float");

        StatementDefinition definition = new AssignFloatVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $LF");
    }

    @Test
    public void shouldReturnArguments() {
        String type = "java.lang.Float";
        FieldDefinition field = new FieldDefinition("value", type);

        StatementDefinition definition = new AssignFloatVariableDefinition(field);

        assertThat(definition.getArgs()).contains(ClassName.bestGuess(type), "value", 10);
    }

    @Test
    public void shouldBuildStatement() {
        FieldDefinition field = new FieldDefinition("value", "Float");

        StatementDefinition definition = new AssignFloatVariableDefinition(field);

        assertThat(builder.toStatement(definition)).isEqualTo("Float value = 10F;");
    }

}
