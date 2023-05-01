package checkingForCheating;

import firstTask.MyException;
import org.parboiled.common.Tuple3;

import java.util.ArrayList;

public class Course {
    private String mName;
    private ArrayList<Tuple3<Student, Assessment, Cheating>> mInformationAboutStudents;
    private Integer mCountTasks;
    private Integer mAverageTimePerTask;

    public String getName() {
        return mName;
    }

    public Course(String name, Integer CountTasks,Integer AverageTimePerTask) {
        this.mName = name;
        this.mInformationAboutStudents = new ArrayList<>();
        this.mCountTasks = CountTasks;
        this.mAverageTimePerTask = AverageTimePerTask;
    }

    public void AddStudent(Student student) throws MyException {
        mInformationAboutStudents.add(new Tuple3<>(student, new Assessment(0), Cheating.Unknown));
    }

    public Integer GetAssessmentAndCheatingByName(String nameStudent) throws MyException {
        ////////Пока заглушка
    }
}
