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

    public FilesGenerator(Path sourceDirectoryPath, Path testDirectoryPath) {
        this.sourceDirectoryPath = sourceDirectoryPath;
        this.testDirectoryPath = testDirectoryPath;
    }

    public void generate(GenerationParams params) {
        generateDto(params);
        generateBuilder(params);
        generateTest(params);
    }

    private void generateDto(GenerationParams generationParams) {
        Generator dtoGenerator = new DtoGenerator(generationParams);
        generate(dtoGenerator, sourceDirectoryPath);
    }

    private void generateBuilder(GenerationParams generationParams) {
        Generator builderGenerator = new BuilderGenerator(generationParams);
        generate(builderGenerator, sourceDirectoryPath);
    }

    private void generateTest(GenerationParams generationParams) {
        Generator testGenerator = new TestGenerator(generationParams);
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
