package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseDtoGenerator implements Generator {

    private final String packageName;
    private final ClassName dtoClassName;
    private final List<FieldDefinition> fieldDefinitions;
    private final Collection<MethodSpec> constructors;
    private final FieldDecorator fieldDecorator;
    private final MethodDecorator getterDecorator;

    public BaseDtoGenerator(GenerationParams params, Collection<MethodSpec> constructors, FieldDecorator fieldDecorator, MethodDecorator getterDecorator) {
        this.packageName = params.getPackageName();
        this.dtoClassName = ClassName.get(packageName, params.getDtoClassName());
        this.fieldDefinitions = params.getFieldDefinitions();
        this.constructors = constructors;
        this.fieldDecorator = fieldDecorator;
        this.getterDecorator = getterDecorator;
    }

    @Override
    public JavaFile generate() {
        Builder type = TypeSpec.classBuilder(dtoClassName).addModifiers(Modifier.PUBLIC);
        for (FieldDefinition field : fieldDefinitions) {
            type.addField(generateField(field));
        }
        constructors.forEach(type::addMethod);
        List<MethodSpec> getters = generateGetters();
        getters.forEach(type::addMethod);
        return JavaFile.builder(packageName, type.build()).build();
    }

    private FieldSpec generateField(FieldDefinition field) {
        return fieldDecorator.decorate(FieldSpec.builder(field.getType(), field.getName())).build();
    }

    private List<MethodSpec> generateGetters() {
        List<MethodSpec> getters = new ArrayList<>();
        fieldDefinitions.forEach(field -> getters.add(generateGetter(field)));
        return getters;
    }

    private MethodSpec generateGetter(FieldDefinition field) {
        String name = field.getName();
        MethodSpec.Builder builder = MethodSpec.methodBuilder(GetterMethodNameBuilder.build(field))
                .addModifiers(Modifier.PUBLIC)
                .returns(field.getType())
                .addStatement("return $N", name);
        return getterDecorator.decorate(builder).build();
    }

}
