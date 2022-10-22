package assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

   @Test
    void whenVerticesMinus1WhenVertexNotExists() {
        Box box = new Box(9, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isEqualTo(-1);
   }

    @Test
    void whenVerticesMinus1WhenNegativeEdge() {
        Box box = new Box(8, -10);
        int number = box.getNumberOfVertices();
        assertThat(number)
                .isLessThan(0)
                .isEqualTo(-1);
    }

    @Test
    void whenVertexExists() {
        Box box = new Box(0, 10);
        boolean isExists = box.isExist();
        assertThat(isExists).isTrue();
    }

    @Test
    void whenVertexNotExist() {
        Box box = new Box(5, 4);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse();
    }

    @Test
    void whenAreaIs32() {
        Box box = new Box(8, 2);
        double area = box.getArea();
        assertThat(area).isLessThan(35);
    }

    @Test
    void whenAreaIsCloseTo7() {
        Box box = new Box(4, 2);
        double area = box.getArea();
        assertThat(area).isCloseTo(7.00d, withPrecision(0.08d));
    }
}