package uk.co.mruoc.code;

import com.squareup.javapoet.JavaFile;
import org.junit.Test;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import java.io.IOException;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderGeneratorTest {

    private final FileContentLoader contentLoader = new ClasspathFileContentLoader();
    private final GenerationParams params = new TestGenerationParams();

    private final BuilderGenerator generator = new BuilderGenerator(params);

    @Test
    public void shouldGenerateBuilderJavaFile()  {
        String expectedContent = contentLoader.loadContent("/expected-builder-java.txt");
        JavaFile file = generator.generate();
        String content = extractContent(file);

        assertThat(content).isEqualTo(expectedContent);
    }

    private String extractContent(JavaFile file) {
        try {
            StringBuilder content = new StringBuilder();
            file.writeTo(content);
            return content.toString();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
