package uk.co.mruoc.code;

import com.squareup.javapoet.MethodSpec;

import java.util.Arrays;
import java.util.Collection;

public class ApiDtoGenerator extends BaseDtoGenerator {

    public ApiDtoGenerator(GenerationParams params) {
        super(params, buildConstructors(params), new DefaultFieldDecorator(), new JacksonMethodDecorator());
    }

    private static Collection<MethodSpec> buildConstructors(GenerationParams params) {
        MethodSpec noArgConstructor = buildNoArgConstructor();
        MethodSpec builderArgConstructor = buildBuilderArgConstructor(params);
        return Arrays.asList(noArgConstructor, builderArgConstructor);
    }

    private static MethodSpec buildNoArgConstructor() {
        DtoConstructorGenerator builder = new NoArgConstructorGenerator();
        return builder.build();
    }

    private static MethodSpec buildBuilderArgConstructor(GenerationParams params) {
        DtoConstructorGenerator builder = new BuilderArgDtoConstructorGenerator(params);
        return builder.build();
    }

}
