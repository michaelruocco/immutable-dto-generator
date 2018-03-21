package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.MethodSpec.Builder;

import javax.lang.model.element.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BuilderArgDtoConstructorGenerator implements DtoConstructorGenerator {

    private final ClassName builderClassName;
    private final List<FieldDefinition> fieldDefinitions;

    public BuilderArgDtoConstructorGenerator(GenerationParams params) {
        this(ClassName.get(params.getPackageName(), params.getBuilderClassName()), params.getFieldDefinitions());
    }

    private BuilderArgDtoConstructorGenerator(ClassName builderClassName, List<FieldDefinition> fieldDefinitions) {
        this.builderClassName = builderClassName;
        this.fieldDefinitions = fieldDefinitions;
    }

    @Override
    public MethodSpec build() {
        Builder builder = createBuilder();
        for (FieldDefinition field : fieldDefinitions) {
            builder.addStatement("this.$N = builder.$N()", field.getName(), GetterMethodNameBuilder.build(field));
        }
        return builder.build();
    }

    private Builder createBuilder() {
        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(builderClassName, "builder");
    }

}
