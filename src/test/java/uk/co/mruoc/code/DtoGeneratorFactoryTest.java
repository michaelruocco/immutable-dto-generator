package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DtoGeneratorFactoryTest {

    private final DefaultGenerationParams params = new TestGenerationParams();

    @Test
    public void shouldReturnDefaultDtoGeneratorIfNotApiClass() {
        params.setApiClass(false);

        Generator generator = DtoGeneratorFactory.build(params);

        assertThat(generator).isInstanceOf(DefaultDtoGenerator.class);
    }

    @Test
    public void shouldReturnApiDtoGeneratorIfApiClass() {
        params.setApiClass(true);

        Generator generator = DtoGeneratorFactory.build(params);

        assertThat(generator).isInstanceOf(ApiDtoGenerator.class);
    }

}
