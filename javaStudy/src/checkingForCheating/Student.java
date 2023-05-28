package checkingForCheating;

import java.io.File;
import java.io.FileWriter;

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

    public void AddStudent() {
        var file = new File("src/checkingForCheating/files", "students.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Ошибка создания файла!");
            }
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(" ");
            sb.append(mFirstName);
            sb.append(" ");
            sb.append(mLastName);
            sb.append(" ");
            sb.append(mUniversity);

            fileWriter.write(sb.toString());
        } catch (Exception e) {
            System.out.println("Не удалось добавить пользователя");
        }
    }
}
