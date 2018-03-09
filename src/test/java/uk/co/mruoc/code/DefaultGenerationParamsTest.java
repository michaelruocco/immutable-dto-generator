package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class DefaultGenerationParamsTest {

    private final DefaultGenerationParams params = new DefaultGenerationParams();

    @Test
    public void shouldSetPackageName() {
        String name = "my.package.name";

        params.setPackageName(name);

        assertThat(params.getPackageName()).isEqualTo(name);
    }

    @Test
    public void shouldSetDtoClassName() {
        String name = "MyDtoClass";

        params.setDtoClassName(name);

        assertThat(params.getDtoClassName()).isEqualTo(name);
    }

    @Test
    public void shouldSetBuilderClassName() {
        String name = "MyBuilderClass";

        params.setBuilderClassName(name);

        assertThat(params.getBuilderClassName()).isEqualTo(name);
    }

    @Test
    public void shouldSetTestClassName() {
        String name = "MyTestClass";

        params.setTestClassName(name);

        assertThat(params.getTestClassName()).isEqualTo(name);
    }

    @Test
    public void shouldUseClassNamePlusTestIfTestClassNameNotSet() {
        String name = "MyDtoClass";

        params.setDtoClassName(name);

        assertThat(params.getTestClassName()).isEqualTo(name + "Test");
    }

    @Test
    public void shouldUseClassNamePlusBuilderIfBuilderClassNameNotSet() {
        String name = "MyDtoClass";

        params.setDtoClassName(name);

        assertThat(params.getBuilderClassName()).isEqualTo(name + "Builder");
    }

    @Test
    public void fieldDefinitionsShouldDefaultToEmpty() {
        assertThat(params.getFieldDefinitions()).isEmpty();
    }

    @Test
    public void shouldAddFieldDefinitionWithStringAndClass() {
        String fieldName = "myFieldName";
        Class<?> fieldType = String.class;

        params.addFieldDefinition(fieldName, fieldType);

        List<FieldDefinition> definitions = params.getFieldDefinitions();
        FieldDefinition definition = definitions.get(0);
        assertThat(definitions.size()).isEqualTo(1);
        assertThat(definition.getName()).isEqualTo(fieldName);
        assertThat(definition.getType()).isEqualTo(ClassName.bestGuess(fieldType.getTypeName()));
    }

    @Test
    public void shouldAddFieldDefinitionWithStringAndString() {
        String fieldName = "myFieldName";
        String fieldType = "java.lang.String";

        params.addFieldDefinition(fieldName, fieldType);

        List<FieldDefinition> definitions = params.getFieldDefinitions();
        FieldDefinition definition = definitions.get(0);
        assertThat(definitions.size()).isEqualTo(1);
        assertThat(definition.getName()).isEqualTo(fieldName);
        assertThat(definition.getType()).isEqualTo(ClassName.bestGuess(fieldType));
    }

    @Test
    public void shouldAddFieldDefinitionWithStringAndTypeName() {
        String fieldName = "myFieldName";
        TypeName fieldType = ClassName.bestGuess("java.lang.String");

        params.addFieldDefinition(fieldName, fieldType);

        List<FieldDefinition> definitions = params.getFieldDefinitions();
        FieldDefinition definition = definitions.get(0);
        assertThat(definitions.size()).isEqualTo(1);
        assertThat(definition.getName()).isEqualTo(fieldName);
        assertThat(definition.getType()).isEqualTo(fieldType);
    }

    @Test
    public void shouldAddFieldDefinition() {
        FieldDefinition expectedDefinition = mock(FieldDefinition.class);

        params.addFieldDefinition(expectedDefinition);

        List<FieldDefinition> definitions = params.getFieldDefinitions();
        FieldDefinition definition = definitions.get(0);
        assertThat(definitions.size()).isEqualTo(1);
        assertThat(definition.getName()).isEqualTo(expectedDefinition.getName());
        assertThat(definition.getType()).isEqualTo(expectedDefinition.getType());
    }

}
