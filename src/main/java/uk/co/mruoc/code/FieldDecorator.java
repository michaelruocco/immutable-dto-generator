package uk.co.mruoc.code;

import com.squareup.javapoet.FieldSpec.Builder;

public interface FieldDecorator {

    Builder decorate(Builder fieldSpec);

}
