package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignNumericVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "int");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignNumericVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $L");
    }

    @Test
    public void shouldReturnArguments() {
        TypeName primitiveInt = StringToPrimitiveConverter.toPrimitiveType("int");
        assertThat(definition.getArgs()).contains(primitiveInt, "value", 10);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("int value = 10;");
    }

}
