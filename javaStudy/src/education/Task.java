package education;

import firstTask.MyException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class Task {
    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    private String nameTask;
    @Getter(AccessLevel.PUBLIC)
    private HashMap<Student, Mark> studentAndMark;
    @Getter(AccessLevel.PUBLIC)
    private int budget;

    public Task(String nameTask, int budget) throws MyException {
        this.nameTask = nameTask;
        setBudget(budget);
        studentAndMark = new HashMap<>();
    }

    private Task(@NotNull TaskBuilder taskBuilder){
        this.nameTask = taskBuilder.nameTask;
        this.studentAndMark = taskBuilder.studentAndMark;
        this.budget = taskBuilder.budget;
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
    public boolean stayedWithinBudget() throws MyException {
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

    public static class TaskBuilder {
        private String nameTask; //optional
        private HashMap<Student, Mark> studentAndMark;
        private int budget;

        public TaskBuilder(int budget) throws Exception{
            if (budget < 0)
                throw new MyException("Бюджет не может быть отрицательным");
            else
                this.budget = budget;
            this.studentAndMark = new HashMap<>();
        }

        /**
         * set name of Task
         */
        public TaskBuilder setName(String nameTask) {
            this.nameTask = nameTask;
            return this;
        }

        /**
         * add one student of Task
         */
        public TaskBuilder setOneStudentAndMark(Student student, Mark mark) {
            studentAndMark.put(student, mark);
            return this;
        }

        /**
         * Build the Task object
         */
        public Task build() {
            return new Task(this);
        }
    }
}
