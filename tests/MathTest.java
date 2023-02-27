package firstTask.tests;

import firstTask.Math;
import firstTask.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void factOfZero() throws Exception {
        var expected = 1;
        var result = new Math().fact(0);
        assertEquals(expected, result);
    }

    @Test
    void factOfOrdinaryNumber() throws Exception {
        var expected = 362_880;
        var result = new Math().fact(9);
        assertEquals(expected, result);
    }

    @Test
    void factOfNegativeNumber() throws Exception {
        assertThrows(MyException.class, () -> {
            new Math().fact(-127);
    });
    }

    @Test
    void factOfNumberOver12() throws Exception {
        assertThrows(MyException.class, () -> {
            new Math().fact(17);
        });
    }

    @Test
    void signOfZero() {
        var expected = 0;
        var result = new Math().sign(0);
        assertEquals(expected, result);
    }

    @Test
    void signOfPositive() {
        var expected = 1;
        var result = new Math().sign(10_101);
        assertEquals(expected, result);
    }

    @Test
    void signOfNegative() {
        var expected = -1;
        var result = new Math().sign(-17);
        assertEquals(expected, result);
    }
}