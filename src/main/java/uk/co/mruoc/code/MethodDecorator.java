package uk.co.mruoc.code;

import com.squareup.javapoet.MethodSpec.Builder;

public interface MethodDecorator {

    Builder decorate(Builder builder);

}
