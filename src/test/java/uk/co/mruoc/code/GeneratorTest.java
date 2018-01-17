package uk.co.mruoc.code;

import com.squareup.javapoet.JavaFile;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GeneratorTest {

    private final GenerationParams params = new DefaultGenerationParams()
            .setPackageName("uk.co.mruoc.generated")
            .setDtoClassName("CustomerDto")
            .setBuilderClassName("CustomerDtoBuilder")
            .setTestClassName("CustomerDtoTest")
            .addFieldDefinition("id", long.class)
            .addFieldDefinition("firstName", String.class)
            .addFieldDefinition("lastName", String.class)
            .addFieldDefinition("dateOfBirth", LocalDate.class)
            .addFieldDefinition("premium", boolean.class)
            .addFieldDefinition("balance", BigDecimal.class)
            .addFieldDefinition("doubleVal", double.class)
            .addFieldDefinition("integerVal", Integer.class)
            .addFieldDefinition("floatVal", float.class);

    private final Generator builderGenerator = new BuilderGenerator(params);
    private final Generator dtoGenerator = new DtoGenerator(params);
    private final Generator testGenerator = new TestGenerator(params);

    @Test
    public void showGeneratedBuilderCode() throws IOException {
        JavaFile javaFile = builderGenerator.generate();
        javaFile.writeTo(System.out);
    }

    @Test
    public void showGeneratedDtoCode() throws IOException {
        JavaFile javaFile = dtoGenerator.generate();
        javaFile.writeTo(System.out);
    }

    @Test
    public void showGeneratedTestCode() throws IOException {
        JavaFile javaFile = testGenerator.generate();
        javaFile.writeTo(System.out);
    }

}
