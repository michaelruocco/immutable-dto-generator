package uk.co.mruoc.code;

import com.squareup.javapoet.MethodSpec.Builder;

public class NoOpMethodDecorator implements MethodDecorator {

    @Override
    public Builder decorate(Builder builder) {
        return builder;
    }

}
