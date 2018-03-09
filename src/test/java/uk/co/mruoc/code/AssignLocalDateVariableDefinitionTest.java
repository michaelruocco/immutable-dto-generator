package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignLocalDateVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("date", "LocalDate");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignLocalDateVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $T.of($L, $L, $L)");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName className = ClassName.bestGuess("LocalDate");
        assertThat(definition.getArgs()).contains(className, "date", className, 2018, 1, 1);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("LocalDate date = LocalDate.of(2018, 1, 1);");
    }

}
