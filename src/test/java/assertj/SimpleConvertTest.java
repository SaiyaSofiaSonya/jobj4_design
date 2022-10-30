package assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("5", "10", "3", "1", "-3");
        assertThat(list).hasSize(5)
                .hasSize(5)
                .contains("5")
                .contains("10", Index.atIndex(1))
                .doesNotContain("11");
        assertThat(list).first().isEqualTo("5");

    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Sveta", "Kolya", "Vanyz", "Dima", "Nanya");
        assertThat(set).hasSize(5)
                .hasSize(5)
                .noneMatch(e -> e.equals("2"));
        assertThat(set).filteredOnAssertions(s -> assertThat(s).startsWith("S"))
                .first().isEqualTo("Sveta");
    }

    @Test
    void check4EndsToA() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("Sveta", "Kolya", "Vanyz", "Dima", "Nanya");
        assertThat(set).filteredOnAssertions(e -> assertThat(e).endsWith("a"))
                .hasSize(4);

    }

    @Test
    void checkHashMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("Sveta", "Kolya", "Vanyz", "Dima");
        assertThat(map).hasSize(4)
                .containsKey("Sveta")
                .containsValues(1, 2)
                .doesNotContainKey("4")
                .containsEntry("Sveta", 0);

    }
}