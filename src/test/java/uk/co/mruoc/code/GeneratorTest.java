package uk.co.mruoc.code;

import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GeneratorTest {

    private final Path mainSourcePath = Paths.get("src/main/java/");
    private final Path testSourcePath = Paths.get("src/test/java/");

    private final GenerationParams params = new DefaultGenerationParams()
            .setPackageName("uk.co.mruoc.dto")
            .setDtoClassName("CustomerDto")
            .addFieldDefinition("id", long.class)
            .addFieldDefinition("firstName", String.class)
            .addFieldDefinition("lastName", String.class)
            .addFieldDefinition("dateOfBirth", LocalDate.class)
            .addFieldDefinition("premium", boolean.class)
            .addFieldDefinition("balance", BigDecimal.class)
            .addFieldDefinition("doubleVal", double.class)
            .addFieldDefinition("integerVal", Integer.class)
            .addFieldDefinition("floatVal", float.class)
            .addFieldDefinition("shortVal", Short.class)
            .addFieldDefinition("charVal", char.class)
            .addFieldDefinition("byteVal", Byte.class)
            .addFieldDefinition("object", Object.class)
            .addFieldDefinition("date", Date.class)
            .addFieldDefinition("localDateTime", LocalDateTime.class)
            .addFieldDefinition("customClass", MyCustomClass.class);

    private final FilesGenerator generator = new FilesGenerator(mainSourcePath, testSourcePath, params);

    @Test
    public void generateFiles() throws IOException {
        generator.generate();
    }

}
