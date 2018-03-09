package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetterMethodNameBuilderTest {

    @Test
    public void shouldUseIsForBoolean() {
        FieldDefinition definition = new FieldDefinition("enabled", "boolean");

        String methodName = GetterMethodNameBuilder.build(definition);

        assertThat(methodName).isEqualTo("isEnabled");
    }

    @Test
    public void shouldUseGetForNonBoolean() {
        FieldDefinition definition = new FieldDefinition("value", "int");

        String methodName = GetterMethodNameBuilder.build(definition);

        assertThat(methodName).isEqualTo("getValue");
    }

}
