package uk.co.mruoc.code;

import com.squareup.javapoet.TypeName;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DefaultGenerationParams implements GenerationParams {

    private final List<FieldDefinition> fieldDefinitions = new ArrayList<>();

    private String packageName;
    private String dtoClassName;
    private String builderClassName;
    private String testClassName;
    private boolean apiClass;

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
        if (StringUtils.isEmpty(builderClassName)) {
            return dtoClassName + "Builder";
        }
        return builderClassName;
    }

    @Override
    public String getTestClassName() {
        if (StringUtils.isEmpty(testClassName)) {
            return dtoClassName + "Test";
        }
        return testClassName;
    }

    @Override
    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitions;
    }

    @Override
    public boolean isApiClass() {
        return apiClass;
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

    public DefaultGenerationParams setApiClass(boolean apiClass) {
        this.apiClass = apiClass;
        return this;
    }

    public DefaultGenerationParams addFieldDefinition(String name, Class<?> type) {
        return addFieldDefinition(new FieldDefinition(name, type));
    }

    public DefaultGenerationParams addFieldDefinition(String name, String typeString) {
        return addFieldDefinition(new FieldDefinition(name, typeString));
    }

    public DefaultGenerationParams addFieldDefinition(String name, TypeName type) {
        return addFieldDefinition(new FieldDefinition(name, type));
    }

    public DefaultGenerationParams addFieldDefinition(FieldDefinition fieldDefinition) {
        this.fieldDefinitions.add(fieldDefinition);
        return this;
    }

}
