package uk.co.mruoc.code;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesGeneratorTest {

    private final Path mainSourcePath = Paths.get("src/main/java/");
    private final Path testSourcePath = Paths.get("src/test/java/");
    private final GenerationParams params = new TestGenerationParams();

    private final FilesGenerator generator = new FilesGenerator(mainSourcePath, testSourcePath, params);

    @Test
    public void generateFiles() {
        String basePath = "src/main/java/uk/co/mruoc/dto/";
        String dtoPath =  basePath + "CustomerDto.java";
        String builderPath = basePath + "CustomerDtoBuilder.java";
        String testPath =  "src/test/java/uk/co/mruoc/dto/CustomerDtoTest.java";

        try {
            generator.generate();

            assertThat(Files.exists(Paths.get(dtoPath))).isTrue();
            assertThat(Files.exists(Paths.get(builderPath))).isTrue();
            assertThat(Files.exists(Paths.get(testPath))).isTrue();
        } finally {
            FileUtils.deleteQuietly(new File(dtoPath).getParentFile());
            FileUtils.deleteQuietly(new File(testPath).getParentFile());
        }
    }

}
