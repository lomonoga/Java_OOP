package checkingForCheating;

/**
 * Класс данных о студенте
 */
public class Student {
    private static int sId = 0;
    public int id;
    private String mFirstName;
    private String mLastName;
    private String mUniversity;

    public Student(
            String firstName,
            String mLastName,
            String university) {
        this.mFirstName = firstName;
        this.mLastName = mLastName;
        this.mUniversity = university;
        this.id = ++Student.sId;
    }
}
