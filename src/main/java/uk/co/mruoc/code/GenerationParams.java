package uk.co.mruoc.code;

import java.nio.file.Path;
import java.util.List;

public interface GenerationParams {

    String getPackageName();

    String getDtoClassName();

    String getBuilderClassName();

    String getTestClassName();

    List<FieldDefinition> getFieldDefinitions();

}
