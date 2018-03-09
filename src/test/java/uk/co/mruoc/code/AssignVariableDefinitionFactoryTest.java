package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AssignVariableDefinitionFactoryTest {

    private final AssignVariableDefinitionFactory factory = new AssignVariableDefinitionFactory();
    private final FieldDefinition field = mock(FieldDefinition.class);

    @Test
    public void shouldReturnStringVariableDefinition() {
        given(field.isString()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignStringVariableDefinition.class));
    }

    @Test
    public void shouldReturnBigDecimalVariableDefinition() {
        given(field.isBigDecimal()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignBigDecimalVariableDefinition.class));
    }

    @Test
    public void shouldReturnNumericVariableDefinitionForInt() {
        given(field.isInt()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignNumericVariableDefinition.class));
    }

    @Test
    public void shouldReturnLongVariableDefinition() {
        given(field.isLong()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignLongVariableDefinition.class));
    }

    @Test
    public void shouldReturnFloatVariableDefinition() {
        given(field.isFloat()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignFloatVariableDefinition.class));
    }

    @Test
    public void shouldReturnDoubleVariableDefinition() {
        given(field.isDouble()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignDoubleVariableDefinition.class));
    }

    @Test
    public void shouldReturnNumericVariableDefinitionForShort() {
        given(field.isShort()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignNumericVariableDefinition.class));
    }

    @Test
    public void shouldReturnNumericVariableDefinitionForByte() {
        given(field.isByte()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignNumericVariableDefinition.class));
    }

    @Test
    public void shouldReturnBooleanVariableDefinitionForByte() {
        given(field.isBoolean()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignBooleanVariableDefinition.class));
    }

    @Test
    public void shouldReturnCharVariableDefinitionForByte() {
        given(field.isChar()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignCharVariableDefinition.class));
    }

    @Test
    public void shouldReturnLocalDateVariableDefinitionForByte() {
        given(field.isLocalDate()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignLocalDateVariableDefinition.class));
    }

    @Test
    public void shouldReturnLocalDateTimeVariableDefinitionForByte() {
        given(field.isLocalDateTime()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignLocalDateTimeVariableDefinition.class));
    }

    @Test
    public void shouldReturnObjectVariableDefinitionForInstanceTypeThatHasPublicNoArgConstructor() {
        given(field.instanceTypeHasPublicNoArgumentConstructor()).willReturn(true);

        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignObjectVariableDefinition.class));
    }

    @Test
    public void shouldReturnMockedObjectVariableDefinitionForNotOtherTypesMatched() {
        StatementDefinition definition = factory.get(field);

        assertThat(definition.getClass().equals(AssignMockedObjectVariableDefinition.class));
    }

}
