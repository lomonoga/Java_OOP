package checkingForCheating;

import education.Grade;
import firstTask.MyException;

/**
 * Класс хранит оценку и балл студента
 */
public class Assessment {
    private int points;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    /**
     * @param points Балл студента в диапозоне от 0 до 100
     * @throws MyException Ошибка если балл был вне [0, 100]
     */
    public Assessment(int points) throws MyException {
        if (0 <= points && points <= 100)
            this.points = points;
        else
            throw new MyException("Введите значение в диапозоне от 0 до 100");

        if (points < 40)
            this.grade = Grade.Unsatisfactory;
        else if (this.points < 60)
            this.grade = Grade.Satisfactorily;
        else if (this.points < 80)
            this.grade = Grade.Good;
        else
            this.grade = Grade.Excellent;
    }
}
