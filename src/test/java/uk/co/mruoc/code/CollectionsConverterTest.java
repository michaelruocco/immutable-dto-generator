package uk.co.mruoc.code;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsConverterTest {

    @Test
    public void shouldReturnTrueIfCollectionInterface() {
        assertThat(CollectionsConverter.isCollectionInterface("java.util.List")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Set")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Map")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Collection")).isTrue();

        assertThat(CollectionsConverter.isCollectionInterface("java.lang.Object")).isFalse();
    }

    @Test
    public void shouldReturnTrueIfCollectionInterfaceAndHasGenerics() {
        assertThat(CollectionsConverter.isCollectionInterface("java.util.List<Object>")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Set<Object>")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Map<String, Object>")).isTrue();
        assertThat(CollectionsConverter.isCollectionInterface("java.util.Collection<Object>")).isTrue();

        assertThat(CollectionsConverter.isCollectionInterface("java.lang.Object")).isFalse();
    }

    @Test
    public void shouldConvertListToArrayList() {
        assertThat(CollectionsConverter.toImplementation("java.util.List")).isEqualTo("java.util.ArrayList");
        assertThat(CollectionsConverter.toImplementation("java.util.List<Object>")).isEqualTo("java.util.ArrayList");
    }

    @Test
    public void shouldConvertSetToHashSet() {
        assertThat(CollectionsConverter.toImplementation("java.util.Set")).isEqualTo("java.util.HashSet");
        assertThat(CollectionsConverter.toImplementation("java.util.Set<Object>")).isEqualTo("java.util.HashSet");
    }

    @Test
    public void shouldConvertMapToHashMap() {
        assertThat(CollectionsConverter.toImplementation("java.util.Map")).isEqualTo("java.util.HashMap");
        assertThat(CollectionsConverter.toImplementation("java.util.Map<Object>")).isEqualTo("java.util.HashMap");
    }

    @Test
    public void shouldConvertCollectionToArrayList() {
        assertThat(CollectionsConverter.toImplementation("java.util.Collection")).isEqualTo("java.util.ArrayList");
        assertThat(CollectionsConverter.toImplementation("java.util.Collection<Object>")).isEqualTo("java.util.ArrayList");
    }

}
