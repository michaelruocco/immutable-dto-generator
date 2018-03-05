package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldDefinitionTest {

    @Test
    public void shouldReturnIsLong() {
        assertThat(new FieldDefinition("one", "long").isLong()).isTrue();
    }

    @Test
    public void shouldReturnIsLongForObject() {
        assertThat(new FieldDefinition("two", "java.lang.Long").isLong()).isTrue();
    }

}
