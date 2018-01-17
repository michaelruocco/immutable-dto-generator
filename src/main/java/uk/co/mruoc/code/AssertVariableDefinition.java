package uk.co.mruoc.code;

import com.squareup.javapoet.ClassName;
import org.assertj.core.api.Assertions;

import static java.beans.Introspector.decapitalize;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class AssertVariableDefinition implements StatementDefinition {

    private final ClassName dtoClassName;
    private final FieldDefinition field;

    public AssertVariableDefinition(ClassName dtoClassName, FieldDefinition field) {
        this.dtoClassName = dtoClassName;
        this.field = field;
    }

    @Override
    public String getFormat() {
        return "assertThat($N.get$N()).isEqualTo($N)";
    }

    @Override
    public Object[] getArgs() {
        return new Object[] {
                decapitalize(dtoClassName.simpleName()),
                capitalize(field.getName()),
                field.getName()
        };
    }

}
