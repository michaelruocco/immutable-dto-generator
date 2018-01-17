package uk.co.mruoc.code;

import com.squareup.javapoet.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.lang.model.element.Modifier;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class TestGenerator implements Generator {

    private final String packageName;
    private final ClassName dtoClassName;
    private final ClassName builderClassName;
    private final ClassName testClassName;
    private final List<FieldDefinition> fieldDefinitions;


    public TestGenerator(GenerationParams params) {
        this.packageName = params.getPackageName();
        this.dtoClassName = ClassName.get(packageName, params.getDtoClassName());
        this.builderClassName = ClassName.get(packageName, params.getBuilderClassName());
        this.testClassName = ClassName.get(packageName, params.getTestClassName());
        this.fieldDefinitions = params.getFieldDefinitions();
    }

    @Override
    public JavaFile generate() {
        TypeSpec.Builder type = TypeSpec.classBuilder(testClassName.simpleName()).addModifiers(Modifier.PUBLIC);
        type.addField(FieldSpec.builder(builderClassName, "builder")
                .addModifiers(Modifier.PRIVATE)
                .initializer("new $T()", builderClassName)
                .build());

        for (FieldDefinition field : fieldDefinitions) {
            MethodSpec toString = MethodSpec.methodBuilder("shouldSet" + capitalize(field.getName()))
                    .addAnnotation(Test.class)
                    .returns(void.class)
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("return $S", "Hoverboard")
                    .build();
        }

        return JavaFile.builder(packageName, type.build()).build();
    }

    private FieldSpec generateField(FieldDefinition field) {
        return FieldSpec.builder(field.getType(), field.getName()).addModifiers(Modifier.PRIVATE).build();
    }

}
