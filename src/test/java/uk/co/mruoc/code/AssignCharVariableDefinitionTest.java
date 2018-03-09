package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignCharVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "char");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignCharVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = '$L'");
    }

    @Test
    public void shouldReturnArguments() {
        TypeName charPrimitive = StringToPrimitiveConverter.toPrimitiveType("char");
        assertThat(definition.getArgs()).contains(charPrimitive, "value", 'a');
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("char value = 'a';");
    }

}
