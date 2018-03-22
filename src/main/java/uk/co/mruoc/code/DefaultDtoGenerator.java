package uk.co.mruoc.code;

import com.squareup.javapoet.*;

import java.util.Collection;
import java.util.Collections;

public class DefaultDtoGenerator extends BaseDtoGenerator {

    public DefaultDtoGenerator(GenerationParams params) {
        super(params, buildConstructors(params), new FinalFieldDecorator(), new NoOpMethodDecorator());
    }

    private static Collection<MethodSpec> buildConstructors(GenerationParams params) {
        MethodSpec builderArgConstructor = buildBuilderArgConstructor(params);
        return Collections.singleton(builderArgConstructor);
    }

    private static MethodSpec buildBuilderArgConstructor(GenerationParams params) {
        DtoConstructorGenerator builder = new BuilderArgDtoConstructorGenerator(params);
        return builder.build();
    }

}
