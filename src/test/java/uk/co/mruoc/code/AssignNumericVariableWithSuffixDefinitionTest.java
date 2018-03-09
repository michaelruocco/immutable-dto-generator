package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignNumericVariableWithSuffixDefinitionTest {

    private static final String SUFFIX = "L";
    private final FieldDefinition field = new FieldDefinition("value", "Long");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignNumericVariableWithSuffixDefinition(field, SUFFIX);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $L" + SUFFIX);
    }

    @Test
    public void shouldReturnArguments() {
        ClassName longClass = ClassName.bestGuess("Long");
        assertThat(definition.getArgs()).contains(longClass, "value", 10);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("Long value = 10L;");
    }

}
