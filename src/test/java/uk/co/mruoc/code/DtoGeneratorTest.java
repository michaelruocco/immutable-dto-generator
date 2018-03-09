package uk.co.mruoc.code;

import com.squareup.javapoet.JavaFile;
import org.junit.Test;
import uk.co.mruoc.properties.ClasspathFileContentLoader;
import uk.co.mruoc.properties.FileContentLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class DtoGeneratorTest {

    private final FileContentLoader contentLoader = new ClasspathFileContentLoader();
    private final GenerationParams params = new TestGenerationParams();

    private final Generator generator = new DtoGenerator(params);

    @Test
    public void shouldGenerateBuilderJavaFile()  {
        String expectedContent = contentLoader.loadContent("/expected-dto-java.txt");
        JavaFile file = generator.generate();
        String content = JavaFileContentExtractor.extractContent(file);

        assertThat(content).isEqualTo(expectedContent);
    }



}
