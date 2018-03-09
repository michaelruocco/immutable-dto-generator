package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static uk.co.mruoc.code.StringToTypeNameConverter.toTypeName;

public class FieldTypeTest {

    @Test
    public void shouldReturnType() {
        String type = "java.lang.Object";
        assertThat(buildType(type).getType()).isEqualTo(ClassName.bestGuess(type));
    }

    @Test
    public void shouldReturnInstanceType() {
        String type = "java.lang.Object";
        assertThat(buildType(type).getInstanceType()).isEqualTo(ClassName.bestGuess(type));
    }

    @Test
    public void shouldReturnArrayListInstanceTypeForList() {
        String type = "java.util.List";
        ClassName expected = ClassName.get(ArrayList.class);

        assertThat(buildType(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnHashMapInstanceTypeForMap() {
        String type = "java.util.Map";
        ClassName expected = ClassName.get(HashMap.class);

        assertThat(buildType(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnHashSetInstanceTypeForSet() {
        String type = "java.util.Set";
        ClassName expected = ClassName.get(HashSet.class);

        assertThat(buildType(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnArrayListInstanceTypeForCollection() {
        String type = "java.util.Collection";
        ClassName expected = ClassName.get(ArrayList.class);

        assertThat(buildType(type).getInstanceType()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnIsString() {
        assertThat(buildType("java.lang.String").isString()).isTrue();

        assertThat(buildType("java.lang.Object").isString()).isFalse();
    }

    @Test
    public void shouldReturnIsBigDecimal() {
        assertThat(buildType("java.math.BigDecimal").isBigDecimal()).isTrue();

        assertThat(buildType("java.lang.Object").isBigDecimal()).isFalse();
    }

    @Test
    public void shouldReturnIsDate() {
        assertThat(buildType("java.util.Date").isDate()).isTrue();

        assertThat(buildType("java.lang.Object").isDate()).isFalse();
    }

    @Test
    public void shouldReturnIsLocalDate() {
        assertThat(buildType("java.time.LocalDate").isLocalDate()).isTrue();

        assertThat(buildType("java.lang.Object").isLocalDate()).isFalse();
    }

    @Test
    public void shouldReturnIsLocalDateTime() {
        assertThat(buildType("java.time.LocalDateTime").isLocalDateTime()).isTrue();

        assertThat(buildType("java.lang.Object").isLocalDateTime()).isFalse();
    }

    @Test
    public void shouldReturnIsBoolean() {
        assertThat(buildType("java.lang.Boolean").isBoolean()).isTrue();
        assertThat(buildType("boolean").isBoolean()).isTrue();

        assertThat(buildType("java.lang.Object").isBoolean()).isFalse();
    }

    @Test
    public void shouldReturnIsInt() {
        assertThat(buildType("java.lang.Integer").isInt()).isTrue();
        assertThat(buildType("int").isInt()).isTrue();

        assertThat(buildType("java.lang.Object").isBoolean()).isFalse();
    }

    @Test
    public void shouldReturnIsLong() {
        assertThat(buildType("java.lang.Long").isLong()).isTrue();
        assertThat(buildType("long").isLong()).isTrue();

        assertThat(buildType("java.lang.Object").isLong()).isFalse();
    }

    @Test
    public void shouldReturnIsFloat() {
        assertThat(buildType("java.lang.Float").isFloat()).isTrue();
        assertThat(buildType("float").isFloat()).isTrue();

        assertThat(buildType("java.lang.Object").isFloat()).isFalse();
    }

    @Test
    public void shouldReturnIsDouble() {
        assertThat(buildType("java.lang.Double").isDouble()).isTrue();
        assertThat(buildType("double").isDouble()).isTrue();

        assertThat(buildType("java.lang.Object").isDouble()).isFalse();
    }

    @Test
    public void shouldReturnIsShort() {
        assertThat(buildType("java.lang.Short").isShort()).isTrue();
        assertThat(buildType("short").isShort()).isTrue();

        assertThat(buildType("java.lang.Object").isShort()).isFalse();
    }

    @Test
    public void shouldReturnIsByte() {
        assertThat(buildType("java.lang.Byte").isByte()).isTrue();
        assertThat(buildType("byte").isByte()).isTrue();

        assertThat(buildType("java.lang.Object").isByte()).isFalse();
    }

    @Test
    public void shouldReturnIsChar() {
        assertThat(buildType("java.lang.Character").isChar()).isTrue();
        assertThat(buildType("char").isChar()).isTrue();

        assertThat(buildType("java.lang.Object").isChar()).isFalse();
    }

    @Test
    public void shouldReturnIsPrimitive() {
        assertThat(buildType("boolean").isPrimitive()).isTrue();
        assertThat(buildType("int").isPrimitive()).isTrue();
        assertThat(buildType("long").isPrimitive()).isTrue();
        assertThat(buildType("float").isPrimitive()).isTrue();
        assertThat(buildType("double").isPrimitive()).isTrue();
        assertThat(buildType("short").isPrimitive()).isTrue();
        assertThat(buildType("byte").isPrimitive()).isTrue();
        assertThat(buildType("char").isChar()).isTrue();

        assertThat(buildType("java.lang.Object").isChar()).isFalse();
    }

    @Test
    public void shouldReturnInstanceTypeHasPublicNoArgumentConstructor() {
        assertThat(buildType("java.lang.Object").instanceTypeHasPublicNoArgumentConstructor()).isTrue();
        assertThat(buildType("uk.co.mruoc.code.OneArgConstructorObject").instanceTypeHasPublicNoArgumentConstructor()).isFalse();
    }

    @Test
    public void shouldReturnIsGenericCollection() {
        assertThat(buildType("java.util.List").isGenericCollection()).isTrue();
        assertThat(buildType("java.util.Set").isGenericCollection()).isTrue();
        assertThat(buildType("java.util.Map").isGenericCollection()).isTrue();
        assertThat(buildType("java.util.Collection").isGenericCollection()).isTrue();

        assertThat(buildType("java.lang.Object").isGenericCollection()).isFalse();
    }

    private FieldType buildType(String type) {
        return new FieldType(StringToTypeNameConverter.toTypeName(type));
    }

}
