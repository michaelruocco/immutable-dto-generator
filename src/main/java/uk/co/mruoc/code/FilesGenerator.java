package uk.co.mruoc.code;

import com.squareup.javapoet.JavaFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesGenerator {

    private final Path sourceDirectoryPath;
    private final Path testDirectoryPath;

    private final Generator dtoGenerator;
    private final Generator builderGenerator;
    private final Generator testGenerator;

    public FilesGenerator(Path sourceDirectoryPath, Path testDirectoryPath, GenerationParams generationParams) {
        this.sourceDirectoryPath = sourceDirectoryPath;
        this.testDirectoryPath = testDirectoryPath;
        this.dtoGenerator = new DtoGenerator(generationParams);
        this.builderGenerator = new BuilderGenerator(generationParams);
        this.testGenerator = new TestGenerator(generationParams);
    }

    public void generate() {
        generateDto();
        generateBuilder();
        generateTest();
    }

    private void generateDto() {
        generate(dtoGenerator, sourceDirectoryPath);
    }

    private void generateBuilder() {
        generate(builderGenerator, sourceDirectoryPath);
    }

    private void generateTest() {
        generate(testGenerator, testDirectoryPath);
    }

    private void generate(Generator generator, Path path) {
        try {
            JavaFile file = generator.generate();
            deleteIfExists(path, file);
            file.writeTo(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void deleteIfExists(Path path, JavaFile file) throws IOException {
        Path filePath = Paths.get(path.toString(), file.toJavaFileObject().getName());
        Files.deleteIfExists(filePath);
    }

}
