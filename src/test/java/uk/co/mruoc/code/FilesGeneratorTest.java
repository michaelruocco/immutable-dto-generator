package uk.co.mruoc.code;

import org.junit.Test;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class FilesGeneratorTest {

    private final Path mainSourcePath = Paths.get("src/main/java/");
    private final Path testSourcePath = Paths.get("src/test/java/");
    private final GenerationParams params = new TestGenerationParams();

    private final FilesGenerator generator = new FilesGenerator(mainSourcePath, testSourcePath, params);

    @Test
    public void generateFiles() {
        generator.generate();
    }

}
