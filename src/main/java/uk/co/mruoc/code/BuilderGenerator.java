package uk.co.mruoc.code;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class BuilderGenerator implements Generator {

    private final GetterMethodNameBuilder getterMethodNameBuilder = new GetterMethodNameBuilder();

    private final String packageName;
    private final ClassName dtoClassName;
    private final ClassName builderClassName;
    private final List<FieldDefinition> fieldDefinitions;

    public BuilderGenerator(GenerationParams builder) {
        this.packageName = builder.getPackageName();
        this.dtoClassName = ClassName.get(packageName, builder.getDtoClassName());
        this.builderClassName = ClassName.get(packageName, builder.getBuilderClassName());
        this.fieldDefinitions = builder.getFieldDefinitions();
    }

    @Override
    public JavaFile generate() {
        TypeSpec.Builder type = TypeSpec.classBuilder(builderClassName.simpleName()).addModifiers(Modifier.PUBLIC);
        for (FieldDefinition field : fieldDefinitions) {
            addField(type, field);
        }
        type.addMethod(generateBuildMethod());
        return JavaFile.builder(packageName, type.build()).build();
    }

    private void addField(TypeSpec.Builder type, FieldDefinition field) {
        type.addField(generateField(field));
        type.addMethod(generateGetter(field));
        type.addMethod(generateSetter(field));
    }

    private FieldSpec generateField(FieldDefinition field) {
        return FieldSpec.builder(field.getType(), field.getName()).addModifiers(Modifier.PRIVATE).build();
    }

    private MethodSpec generateGetter(FieldDefinition field) {
        String name = field.getName();
        return MethodSpec.methodBuilder(getterMethodNameBuilder.build(field))
                .addModifiers(Modifier.PUBLIC)
                .returns(field.getType())
                .addStatement("return $N", name)
                .build();
    }

    private MethodSpec generateSetter(FieldDefinition field) {
        String name = field.getName();
        return MethodSpec.methodBuilder("set" + capitalize(name))
                .addModifiers(Modifier.PUBLIC)
                .returns(builderClassName)
                .addParameter(field.getType(), name)
                .addStatement("this.$N = $N", name, name)
                .addStatement("return this")
                .build();
    }

    private MethodSpec generateBuildMethod() {
        return MethodSpec.methodBuilder("build")
                .addModifiers(Modifier.PUBLIC)
                .returns(dtoClassName)
                .addStatement("return new $T(this)", dtoClassName)
                .build();
    }

}
