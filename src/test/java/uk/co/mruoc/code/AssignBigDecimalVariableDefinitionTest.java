package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignBigDecimalVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("value", "BigDecimal");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignBigDecimalVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $T.valueOf($L)");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName className = ClassName.bestGuess("BigDecimal");
        assertThat(definition.getArgs()).contains(className, "value", className, 10);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("BigDecimal value = BigDecimal.valueOf(10);");
    }

}
