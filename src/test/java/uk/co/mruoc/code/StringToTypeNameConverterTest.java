package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringToTypeNameConverterTest {

    private final StringToTypeNameConverter converter = new StringToTypeNameConverter();

    @Test
    public void shouldConvertInvalidValue() {
        String name = "Invalid-Value";

        Throwable thrown = catchThrowable(() -> converter.toTypeName(name));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("part 'Invalid-Value' is keyword");
    }

    @Test
    public void shouldConvertAnyValue() {
        String name = "AnyValue";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertString() {
        String name = "String";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertFullyQualifiedString() {
        String name = "java.lang.String";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertArray() {
        String name = "String[]";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertListWithGenerics() {
        String name = "List<String>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertNestedListsWithGenerics() {
        String name = "List<List<String>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertDoubleNestedListsWithGenerics() {
        String name = "List<List<List<String>>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapWithGenerics() {
        String name = "Map<String, String>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapWithDifferentGenerics() {
        String name = "Map<String, Object>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertListOfMapsWithGenerics() {
        String name = "List<Map<String, String>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertListOfMapsWithDifferentGenerics() {
        String name = "List<Map<String, Object>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapOfListsWithGenerics() {
        String name = "Map<String, List<String>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapOfListsForKeyWithGenerics() {
        String name = "Map<List<String>, Object>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapOfListsOfListsWithGenerics() {
        String name = "Map<List<String>, List<Object>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

    @Test
    public void shouldConvertMapOfMapsWithGenerics() {
        String name = "Map<Map<String, Object>, Map<Object, String>>";

        TypeName type = converter.toTypeName(name);

        assertThat(type.toString()).isEqualTo(name);
    }

}
