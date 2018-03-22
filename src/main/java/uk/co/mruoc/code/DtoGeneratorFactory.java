package uk.co.mruoc.code;

public class DtoGeneratorFactory {

    public static Generator build(GenerationParams params) {
        if (params.isApiClass()) {
            return new ApiDtoGenerator(params);
        }
        return new DefaultDtoGenerator(params);
    }

}
