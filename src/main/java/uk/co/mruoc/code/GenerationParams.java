package uk.co.mruoc.code;

import java.util.List;

public interface GenerationParams {

    String getPackageName();

    String getDtoClassName();

    String getBuilderClassName();

    String getTestClassName();

    List<FieldDefinition> getFieldDefinitions();

    boolean isApiClass();

}
