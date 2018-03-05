package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringToPrimitiveConverterTest {

    @Test
    public void shouldThrowExceptionIfNotValidPrimitiveType() {
        String name = "Invalid-Value";

        Throwable thrown = catchThrowable(() -> StringToPrimitiveConverter.toPrimitiveType(name));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid primitive type 'Invalid-Value'");
    }
}
