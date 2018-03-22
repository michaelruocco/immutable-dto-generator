package uk.co.mruoc.code;

import com.squareup.javapoet.FieldSpec.Builder;

import static javax.lang.model.element.Modifier.*;

public class FinalFieldDecorator implements FieldDecorator {

    @Override
    public Builder decorate(Builder builder) {
        return builder.addModifiers(PRIVATE, FINAL);
    }

}
