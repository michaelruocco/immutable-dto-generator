package uk.co.mruoc.code;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DefaultGenerationParams implements GenerationParams {

    private String packageName;
    private String dtoClassName;
    private String builderClassName;
    private String testClassName;
    private List<FieldDefinition> fieldDefinitions = new ArrayList<>();

    @Override
    public String getPackageName() {
        return packageName;
    }

    @Override
    public String getDtoClassName() {
        return dtoClassName;
    }

    @Override
    public String getBuilderClassName() {
        return builderClassName;
    }

    @Override
    public String getTestClassName() {
        return testClassName;
    }

    @Override
    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitions;
    }

    public DefaultGenerationParams setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public DefaultGenerationParams setDtoClassName(String dtoClassName) {
        this.dtoClassName = dtoClassName;
        return this;
    }

    public DefaultGenerationParams setBuilderClassName(String builderClassName) {
        this.builderClassName = builderClassName;
        return this;
    }

    public DefaultGenerationParams setTestClassName(String testClassName) {
        this.testClassName = testClassName;
        return this;
    }

    public DefaultGenerationParams addFieldDefinition(String name, Type type) {
        return addFieldDefinition(new FieldDefinition(name, type));
    }

    public DefaultGenerationParams addFieldDefinition(FieldDefinition fieldDefinition) {
        this.fieldDefinitions.add(fieldDefinition);
        return this;
    }

}
