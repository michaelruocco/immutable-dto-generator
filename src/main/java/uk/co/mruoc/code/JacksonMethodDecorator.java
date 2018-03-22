package uk.co.mruoc.code;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.javapoet.MethodSpec.Builder;

public class JacksonMethodDecorator implements MethodDecorator {

    @Override
    public Builder decorate(Builder builder) {
        return builder.addAnnotation(JsonProperty.class);
    }

}
