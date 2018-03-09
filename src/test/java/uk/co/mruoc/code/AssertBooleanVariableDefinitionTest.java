package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertBooleanVariableDefinitionTest {

    private final ClassName className = ClassName.bestGuess("MyClass");
    private final FieldDefinition field = new FieldDefinition("enabled", "boolean");
    private final StatementBuilder builder = new StatementBuilder();

    private final AssertBooleanVariableDefinition definition = new AssertBooleanVariableDefinition(className, field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("assertThat($N.is$N()).isEqualTo($N)");
    }

    @Test
    public void shouldReturnArguments() {
        assertThat(definition.getArgs()).contains("myClass", "Enabled", "enabled");
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("assertThat(myClass.isEnabled()).isEqualTo(enabled);");
    }

}
