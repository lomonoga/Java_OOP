package education;

import firstTask.MyException;

import java.util.HashMap;
import java.util.Map;

public class Task {
    private String nameTask;
    private HashMap<Student, Mark> studentAndMark;
    private int budget;

    public Task(String nameTask, int budget) throws MyException {
        this.nameTask = nameTask;
        setBudget(budget);
        studentAndMark = new HashMap<>();
    }

    public String getNameTask(){
        return this.nameTask;
    }

    private void setBudget(int budget) throws MyException {
        if (budget < 0)
            throw new MyException("Бюджет не может быть отрицательным");
        else
            this.budget = budget;
    }

    /**
     * Adds a Student and their grade
     * */
    public void addStudentAndMark(Student student, Mark mark) {
        studentAndMark.put(student, mark);
    }

    /**
     * Determines if the budget is enough to pay scholarships to students within one assignment
     * If a student is over 55 years old, then he is entitled to a surcharge of 20%
     * Returns type bool
     * */
    public boolean stayedWithinBudget() throws MyException{
        if (studentAndMark.values().isEmpty())
            throw new MyException("Вы не добавили ни одного студента");
        var realBudget = 0;
        for (Map.Entry<Student, Mark> entry : studentAndMark.entrySet()) {
            Student student = entry.getKey();
            Mark mark = entry.getValue();
            realBudget += mark.getScholarship() * (student.getAge() > 55 ? 1.2 : 1);
        }
        return budget >= realBudget;
    }
}
