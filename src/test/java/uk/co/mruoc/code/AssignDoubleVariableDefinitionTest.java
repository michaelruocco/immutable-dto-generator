package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignDoubleVariableDefinitionTest {

    private final StatementBuilder builder = new StatementBuilder();

    @Test
    public void shouldReturnFormat() {
        FieldDefinition field = new FieldDefinition("value", "double");

        StatementDefinition definition = new AssignDoubleVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $L");
    }

    @Test
    public void shouldReturnObjectFormat() {
        FieldDefinition field = new FieldDefinition("value", "Double");

        StatementDefinition definition = new AssignDoubleVariableDefinition(field);

        assertThat(definition.getFormat()).isEqualTo("$T $N = $LD");
    }

    @Test
    public void shouldReturnArguments() {
        String type = "java.lang.Double";
        FieldDefinition field = new FieldDefinition("value", type);

        StatementDefinition definition = new AssignDoubleVariableDefinition(field);

        assertThat(definition.getArgs()).contains(ClassName.bestGuess(type), "value", 10);
    }

    @Test
    public void shouldBuildStatement() {
        FieldDefinition field = new FieldDefinition("value", "Double");

        StatementDefinition definition = new AssignDoubleVariableDefinition(field);

        assertThat(builder.toStatement(definition)).isEqualTo("Double value = 10D;");
    }

}
