package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignLocalDateTimeVariableDefinitionTest {

    private final FieldDefinition field = new FieldDefinition("date", "LocalDateTime");
    private final StatementBuilder builder = new StatementBuilder();

    private final StatementDefinition definition = new AssignLocalDateTimeVariableDefinition(field);

    @Test
    public void shouldReturnFormat() {
        assertThat(definition.getFormat()).isEqualTo("$T $N = $T.of($L, $L, $L, $L, $L, $L, $L)");
    }

    @Test
    public void shouldReturnArguments() {
        ClassName className = ClassName.bestGuess("LocalDateTime");
        assertThat(definition.getArgs()).contains(className, "date", className, 2018, 1, 1, 12, 0, 0 ,0);
    }

    @Test
    public void shouldBuildStatement() {
        assertThat(builder.toStatement(definition)).isEqualTo("LocalDateTime date = LocalDateTime.of(2018, 1, 1, 12, 0, 0, 0);");
    }

}
