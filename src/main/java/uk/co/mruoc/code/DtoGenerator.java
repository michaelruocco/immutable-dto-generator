package uk.co.mruoc.code;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class DtoGenerator implements Generator {

    private final String packageName;
    private final ClassName dtoClassName;
    private final ClassName builderClassName;
    private final List<FieldDefinition> fieldDefinitions;

    public DtoGenerator(GenerationParams builder) {
        this.packageName = builder.getPackageName();
        this.dtoClassName = ClassName.get(packageName, builder.getDtoClassName());
        this.builderClassName = ClassName.get(packageName, builder.getBuilderClassName());
        this.fieldDefinitions = builder.getFieldDefinitions();
    }

    @Override
    public JavaFile generate() {
        TypeSpec.Builder type = TypeSpec.classBuilder(dtoClassName).addModifiers(Modifier.PUBLIC);
        for (FieldDefinition field : fieldDefinitions) {
            type.addField(generateField(field));
        }
        type.addMethod(generateConstructor());
        List<MethodSpec> getters = generateGetters();
        getters.forEach(type::addMethod);
        return JavaFile.builder(packageName, type.build()).build();
    }

    private FieldSpec generateField(FieldDefinition field) {
        return FieldSpec.builder(field.getType(), field.getName()).addModifiers(Modifier.PRIVATE).build();
    }

    private MethodSpec generateConstructor() {
        MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(builderClassName, "builder");
        for (FieldDefinition fieldDefinition : fieldDefinitions) {
            constructor.addStatement("this.$N = builder.get$N()", fieldDefinition.getName(), capitalize(fieldDefinition.getName()));
        }
        return constructor.build();
    }

    private List<MethodSpec> generateGetters() {
        List<MethodSpec> getters = new ArrayList<>();
        fieldDefinitions.forEach(field -> getters.add(generateGetter(field)));
        return getters;
    }

    private MethodSpec generateGetter(FieldDefinition field) {
        String name = field.getName();
        return MethodSpec.methodBuilder("get" + capitalize(name))
                .addModifiers(Modifier.PUBLIC)
                .returns(field.getType())
                .addStatement("return $N", name)
                .build();
    }

}
