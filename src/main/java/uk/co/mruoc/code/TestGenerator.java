package uk.co.mruoc.code;

import com.squareup.javapoet.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.lang.model.element.Modifier;
import java.util.List;

import static java.beans.Introspector.*;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class TestGenerator implements Generator {

    private final String packageName;
    private final ClassName dtoClassName;
    private final ClassName builderClassName;
    private final ClassName testClassName;
    private final List<FieldDefinition> fieldDefinitions;

    private final AssignVariableDefinitionFactory assignVariableFactory;
    private final AssertVariableDefinitionFactory assertVariableFactory;

    public TestGenerator(GenerationParams params) {
        this.packageName = params.getPackageName();
        this.dtoClassName = ClassName.get(packageName, params.getDtoClassName());
        this.builderClassName = ClassName.get(packageName, params.getBuilderClassName());
        this.testClassName = ClassName.get(packageName, params.getTestClassName());
        this.fieldDefinitions = params.getFieldDefinitions();

        this.assignVariableFactory = new AssignVariableDefinitionFactory();
        this.assertVariableFactory = new AssertVariableDefinitionFactory(dtoClassName);
    }

    @Override
    public JavaFile generate() {
        TypeSpec.Builder type = TypeSpec.classBuilder(testClassName.simpleName()).addModifiers(Modifier.PUBLIC);
        type.addField(FieldSpec.builder(builderClassName, "builder")
                .addModifiers(Modifier.PRIVATE)
                .initializer("new $T()", builderClassName)
                .build());

        for (FieldDefinition field : fieldDefinitions) {
            type.addMethod(generateFieldTest(field));
        }

        return JavaFile.builder(packageName, type.build())
                .addStaticImport(Assertions.class, "assertThat")
                .build();
    }

    private MethodSpec generateFieldTest(FieldDefinition field) {
        String fieldName = capitalize(field.getName());
        String dtoVariableName = decapitalize(dtoClassName.simpleName());
        StatementDefinition assignStatement = assignVariableFactory.get(field);
        StatementDefinition assertStatement = assertVariableFactory.get(field);
        return MethodSpec.methodBuilder("shouldSet" + fieldName)
                .addAnnotation(Test.class)
                .returns(void.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement(assignStatement.getFormat(), assignStatement.getArgs())
                .addStatement("$T $N = builder.set$N($N).build()",  dtoClassName, dtoVariableName, fieldName, field.getName())
                .addStatement(assertStatement.getFormat(), assertStatement.getArgs())
                .build();
    }


}
