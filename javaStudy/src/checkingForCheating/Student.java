package checkingForCheating;

public class Student {
    private static int sId = 0;
    public int id;
    private String firstName;
    private String lastName;
    private String university;
    private int mark;
    private int totalPoints;

    public Student(
            String firstName,
            String lastName,
            String university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.id = ++Student.sId;
    }
}
