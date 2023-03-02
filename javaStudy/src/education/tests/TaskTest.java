package education.tests;

import education.Mark;
import education.Student;
import education.Task;
import firstTask.MyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testBudgetZeroCostsZero() throws MyException {
        var expected = true;
        var task = new Task("C#_Task",0);
        task.addStudentAndMark(new Student("Ilya", "NoCode", "Bob", 2000, 1, 1),
                new Mark(30));
        task.addStudentAndMark(new Student("Roman", "Aleekseev", "Victorovich", 2003, 11, 28),
                new Mark(45));
        var result = task.stayedWithinBudget();
        assertEquals(expected, result);
    }

    @Test
    void testBudgetNoStudents() throws MyException {
        assertThrows(MyException.class, () -> {
            new Task("NoTask", 10_000).stayedWithinBudget();
        });
    }

    @Test
    void testBudgetIsLessThanPayments() throws MyException {
        var expected = false;
        var task = new Task("Java_Task",9_019);
        task.addStudentAndMark(new Student("Mom", "Dad", "Brother", 1950, 7, 30),
                new Mark(100));
        task.addStudentAndMark(new Student("Kirill", "Go", "Job", 1999, 5, 16),
                new Mark(90));
        var result = task.stayedWithinBudget();
        assertEquals(expected, result);
    }

    @Test
    void testBudgetOverSpending() throws MyException {
        var expected = true;
        var task = new Task("Python_Task",100_000);
        task.addStudentAndMark(new Student("hh.ru", "No", "No", 1950, 7, 30),
                new Mark(76));
        task.addStudentAndMark(new Student("No", "No", "No", 1999, 5, 16),
                new Mark(98));
        task.addStudentAndMark(new Student("Git", "Simple", "", 2006, 2, 22),
                new Mark(1));
        var result = task.stayedWithinBudget();
        assertEquals(expected, result);
    }
}