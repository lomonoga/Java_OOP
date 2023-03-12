package education;

import education.interfaces.IAdmittance;
import firstTask.MyException;

public class Mark implements IAdmittance {
    private Grade grade;
    private double point;
    private boolean passed;

    public Mark(double point) throws MyException {
        setPoint(point);
        setGrade();
        setPassed();
    }

    public Grade getGrade(){
        return this.grade;
    }

    public double getPoint(){
        return this.point;
    }

    public boolean getPassed(){
        return this.passed;
    }

    private void setPoint(double point) throws MyException {
        if (point < 0 || 100 < point)
            throw new MyException("Введите число в диапозоне от 0 до 100");
        else
            this.point = point;
    }

    private void setPassed(){
        this.passed = point >= 40;
    }

    private void setGrade(){
        if (this.point < 40)
            this.grade = Grade.Unsatisfactory;
        else if (this.point < 60)
            this.grade = Grade.Satisfactorily;
        else if (this.point < 80)
            this.grade = Grade.Good;
        else
            this.grade = Grade.Excellent;
    }

    /**
     * Returns the student's possible scholarship based on the results of the Grade
     * If the student received Good return 2700
     * If the student received Excellent return 4100
     * If student did not pass return 0
     * */
    public int getScholarship(){
        if (grade == Grade.Good)
            return 2700;
        else if (grade == Grade.Excellent)
            return 4100;
        return 0;
    }
}
