package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignBooleanVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("enabled", "boolean");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignBooleanVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = new $T().nextBoolean()");
    }

    @Test
    public void shouldReturnArguments() {
        TypeName booleanPrimitive = StringToPrimitiveConverter.toPrimitiveType("boolean");
        assertThat(definition.getArgs()).contains(booleanPrimitive, "enabled", Random.class);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("boolean enabled = new java.util.Random().nextBoolean();");
    }

}
