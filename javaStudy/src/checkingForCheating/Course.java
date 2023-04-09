package checkingForCheating;

import firstTask.MyException;
import org.parboiled.common.Tuple3;

import java.util.ArrayList;

public class Course {
    private String mName;
    private ArrayList<Tuple3<Student, Assessment, Cheating>> mInformationAboutStudents;
    private ArrayList<Task> mAllTasks;

    public String getName() {
        return mName;
    }

    public Course(String name) {
        this.mName = name;
        this.mInformationAboutStudents = new ArrayList<>();
        this.mAllTasks = new ArrayList<>();
    }

    public void AddStudent(Student student) throws MyException {
        mInformationAboutStudents.add(new Tuple3<>(student, new Assessment(0), Cheating.Unknown));
    }

    public void AddTask(Task task) {
        mAllTasks.add(task);
    }
}
