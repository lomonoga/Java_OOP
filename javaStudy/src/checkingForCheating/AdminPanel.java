package checkingForCheating;

import java.io.File;
import java.io.FileWriter;

public class AdminPanel {
    public void AddStudent(String firstName, String lastName, String university) throws Exception {
        new Student(firstName, lastName, university).AddStudent();
    }

    ///Нужно ещ читать студентов и добавлять курсы
}
