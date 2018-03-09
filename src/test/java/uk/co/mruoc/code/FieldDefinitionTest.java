package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldDefinitionTest {

    private static final String FIELD_NAME = "field";

    @Test
    public void shouldReturnName() {
        assertThat(buildDefinition("java.lang.Object").getName()).isEqualTo(FIELD_NAME);
    }

    @Test
    public void shouldReturnType() {
        String type = "java.lang.Object";
        assertThat(buildDefinition(type).getType()).isEqualTo(ClassName.bestGuess(type));
    }

    @Test
    public void shouldReturnInstanceType() {
        String type = "java.lang.Object";
        assertThat(buildDefinition(type).getInstanceType()).isEqualTo(ClassName.bestGuess(type));
    }

    @Test
    public void shouldReturnArrayListInstanceTypeForList() {
        String type = "java.util.List";
        ClassName expected = ClassName.get(ArrayList.class);

        assertThat(buildDefinition(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnHashMapInstanceTypeForMap() {
        String type = "java.util.Map";
        ClassName expected = ClassName.get(HashMap.class);

        assertThat(buildDefinition(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnHashSetInstanceTypeForSet() {
        String type = "java.util.Set";
        ClassName expected = ClassName.get(HashSet.class);

        assertThat(buildDefinition(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnArrayListInstanceTypeForCollection() {
        String type = "java.util.Collection";
        ClassName expected = ClassName.get(ArrayList.class);

        assertThat(buildDefinition(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnIsString() {
        assertThat(buildDefinition("java.lang.String").isString()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isString()).isFalse();
    }

    @Test
    public void shouldReturnIsBigDecimal() {
        assertThat(buildDefinition("java.math.BigDecimal").isBigDecimal()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isBigDecimal()).isFalse();
    }

    @Test
    public void shouldReturnIsDate() {
        assertThat(buildDefinition("java.util.Date").isDate()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isDate()).isFalse();
    }

    @Test
    public void shouldReturnIsLocalDate() {
        assertThat(buildDefinition("java.time.LocalDate").isLocalDate()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isLocalDate()).isFalse();
    }

    @Test
    public void shouldReturnIsLocalDateTime() {
        assertThat(buildDefinition("java.time.LocalDateTime").isLocalDateTime()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isLocalDateTime()).isFalse();
    }

    @Test
    public void shouldReturnIsBoolean() {
        assertThat(buildDefinition("java.lang.Boolean").isBoolean()).isTrue();
        assertThat(buildDefinition("boolean").isBoolean()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isBoolean()).isFalse();
    }

    @Test
    public void shouldReturnIsInt() {
        assertThat(buildDefinition("java.lang.Integer").isInt()).isTrue();
        assertThat(buildDefinition("int").isInt()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isBoolean()).isFalse();
    }

    @Test
    public void shouldReturnIsLong() {
        assertThat(buildDefinition("java.lang.Long").isLong()).isTrue();
        assertThat(buildDefinition("long").isLong()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isLong()).isFalse();
    }

    @Test
    public void shouldReturnIsFloat() {
        assertThat(buildDefinition("java.lang.Float").isFloat()).isTrue();
        assertThat(buildDefinition("float").isFloat()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isFloat()).isFalse();
    }

    @Test
    public void shouldReturnIsDouble() {
        assertThat(buildDefinition("java.lang.Double").isDouble()).isTrue();
        assertThat(buildDefinition("double").isDouble()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isDouble()).isFalse();
    }

    @Test
    public void shouldReturnIsShort() {
        assertThat(buildDefinition("java.lang.Short").isShort()).isTrue();
        assertThat(buildDefinition("short").isShort()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isShort()).isFalse();
    }

    @Test
    public void shouldReturnIsByte() {
        assertThat(buildDefinition("java.lang.Byte").isByte()).isTrue();
        assertThat(buildDefinition("byte").isByte()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isByte()).isFalse();
    }

    @Test
    public void shouldReturnIsChar() {
        assertThat(buildDefinition("java.lang.Character").isChar()).isTrue();
        assertThat(buildDefinition("char").isChar()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isChar()).isFalse();
    }

    @Test
    public void shouldReturnIsPrimitive() {
        assertThat(buildDefinition("boolean").isPrimitive()).isTrue();
        assertThat(buildDefinition("int").isPrimitive()).isTrue();
        assertThat(buildDefinition("long").isPrimitive()).isTrue();
        assertThat(buildDefinition("float").isPrimitive()).isTrue();
        assertThat(buildDefinition("double").isPrimitive()).isTrue();
        assertThat(buildDefinition("short").isPrimitive()).isTrue();
        assertThat(buildDefinition("byte").isPrimitive()).isTrue();
        assertThat(buildDefinition("char").isChar()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isChar()).isFalse();
    }

    @Test
    public void shouldReturnInstanceTypeHasPublicNoArgumentConstructor() {
        assertThat(buildDefinition("java.lang.Object").instanceTypeHasPublicNoArgumentConstructor()).isTrue();
        assertThat(buildDefinition("uk.co.mruoc.code.OneArgConstructorObject").instanceTypeHasPublicNoArgumentConstructor()).isFalse();
    }

    @Test
    public void shouldReturnIsGenericCollection() {
        assertThat(buildDefinition("java.util.List").isGenericCollection()).isTrue();
        assertThat(buildDefinition("java.util.Set").isGenericCollection()).isTrue();
        assertThat(buildDefinition("java.util.Map").isGenericCollection()).isTrue();
        assertThat(buildDefinition("java.util.Collection").isGenericCollection()).isTrue();

        assertThat(buildDefinition("java.lang.Object").isGenericCollection()).isFalse();
    }

    private FieldDefinition buildDefinition(String type) {
        return new FieldDefinition(FIELD_NAME, type);
    }

}
