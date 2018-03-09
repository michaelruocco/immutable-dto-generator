package uk.co.mruoc.code;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

public class StatementBuilder {

    public String toStatement(StatementDefinition definition) {
        MethodSpec spec = toMethodSpec(definition);
        return extractStatement(spec.toString());
    }

    private MethodSpec toMethodSpec(StatementDefinition definition) {
        return MethodSpec.methodBuilder("temp")
                .returns(void.class)
                .addModifiers(Modifier.PUBLIC)
                .addStatement(definition.getFormat(), definition.getArgs())
                .build();
    }

    private String extractStatement(String method) {
        int startIndex = method.indexOf("{") + 1;
        int endIndex = method.lastIndexOf("}");
        return method.substring(startIndex, endIndex).trim();
    }

}
