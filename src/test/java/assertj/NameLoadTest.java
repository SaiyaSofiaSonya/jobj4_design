package assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNoKeyValueSplitter() {
        NameLoad nameLoad = new NameLoad();
        String name = "No key no value";

        assertThatThrownBy(()  ->  nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain the symbol \"=\"")
                .hasMessageContaining(name);
    }

    @Test
    void checkNoKeys() {
        NameLoad nameLoad = new NameLoad();
        String name = "= value";

        assertThatThrownBy(()  ->  nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a key")
                .hasMessageContaining(name);
    }


    @Test
    void checkNoValues() {
        NameLoad nameLoad = new NameLoad();
        String name = "key =";

        assertThatThrownBy(()  ->  nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(name);
    }


}