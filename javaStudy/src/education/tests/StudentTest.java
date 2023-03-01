package education.tests;

import education.Student;
import firstTask.MyException;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testGetFullName() throws MyException {
        var expected = new HashMap<>(){{
            put("firstName", "Ilya");
            put("lastName", "NoCode");
            put("patronymic", "Bob");
        }};
        var result = new Student("Ilya", "NoCode", "Bob", 1818, 9, 9).getFullName();
        assertEquals(expected, result);
    }

    @Test
    void testCheckForNonExistentAge() throws MyException {
        assertThrows(MyException.class, () -> {
            new Student("Ilya", "NoCode", "Bob", 2082, 1, 1).getAge();
        });
    }

    @Test
    void testSetCorrectDate() throws MyException {
        assertThrows(MyException.class, () -> {
            new Student("Ilya", "NoCode", "Bob", 2023, 2, 33).getAge();
        });
    }

    @Test
    void testGetCorrectDate() throws MyException {
        var expected = 22;
        var result = new Student("Ilya", "NoCode", "Bob", 2000, 10, 3).getAge();
        assertEquals(expected, result);
    }
}