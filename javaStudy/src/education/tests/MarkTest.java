package education.tests;

import education.Mark;
import firstTask.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkTest {

    @Test
    void testGetScholarshipZero() throws MyException {
        var expected = 0;
        var result = new Mark(29).getScholarship();
        assertEquals(expected, result);
    }

    @Test
    void testGetScholarshipStandard() throws MyException {
        var expected = 2700;
        var result = new Mark(60).getScholarship();
        assertEquals(expected, result);
    }

    @Test
    void testGetScholarshipHeightened() throws MyException {
        var expected = 4100;
        var result = new Mark(81).getScholarship();
        assertEquals(expected, result);
    }
}