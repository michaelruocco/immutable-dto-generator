package uk.co.mruoc.code;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.MethodSpec.Builder;

import javax.lang.model.element.Modifier;

public class NoArgConstructorGenerator implements DtoConstructorGenerator {

    @Override
    public MethodSpec build() {
        Builder builder = createBuilder();
        builder.addComment("intentionally blank");
        return builder.build();
    }

    private Builder createBuilder() {
        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC);
    }

}
