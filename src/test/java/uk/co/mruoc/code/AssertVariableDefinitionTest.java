package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertVariableDefinitionTest {

    private final ClassName className = ClassName.bestGuess("MyClass");
    private final FieldDefinition field = new FieldDefinition("variable", "boolean");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssertVariableDefinition(className, field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("assertThat($N.get$N()).isEqualTo($N)");
    }

    @Test
    public void shouldReturnArguments() {
        assertThat(definition.getArgs()).contains("myClass", "Variable", "variable");
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("assertThat(myClass.getVariable()).isEqualTo(variable);");
    }

}
