package checkingForCheating;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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

    public Student(
            Integer id,
            String firstName,
            String mLastName,
            String university) {
        this.mFirstName = firstName;
        this.mLastName = mLastName;
        this.mUniversity = university;
        this.id = id;
    }

    /**
     * Позволяет добавить студента
     */
    public void AddStudent() {
        var file = StudentStatic.CheckFile();
        try (FileWriter fileWriter = new FileWriter(file)) {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(" ");
            sb.append(mFirstName);
            sb.append(" ");
            sb.append(mLastName);
            sb.append(" ");
            sb.append(mUniversity);
            sb.append(" ");
            sb.append("NotDel");

            fileWriter.write(sb.toString());
        } catch (Exception e) {
            System.out.println("Не удалось добавить пользователя");
        }
    }

    public static class StudentStatic {
        /**
         * Позволяет найти ФИО студента по id
         * @return Возвращает новый объект Student
         */
        public static Student FindNotDeleteStudentById(Integer id) throws Exception {
            var file = CheckFile();
            var scannerFile = new Scanner(file);

            while (scannerFile.hasNextLine()) {
                var string = scannerFile.nextLine();
                var arrayStudent = Arrays.asList(string.split(" "));
                if (Integer.parseInt(arrayStudent.get(0)) == id
                        && Objects.equals(arrayStudent.get(4), "NotDel")) {
                    return new Student(id, arrayStudent.get(1), arrayStudent.get(2), arrayStudent.get(3));
                }
            }
            throw new Exception("Такого пользователя не существует");
        }

        /**
         * Позволяет найти студента по Имени и Фамилии
         * @param firstName Имя
         * @param mLastName Фамилия
         * @return Обхект студента
         */
        public static Student FindNotDeleteStudentByName(String firstName, String mLastName) throws Exception {
            var file = CheckFile();
            var scannerFile = new Scanner(file);

            while (scannerFile.hasNextLine()) {
                var string = scannerFile.nextLine();
                var arrayStudent = Arrays.asList(string.split(" "));
                if (Objects.equals(arrayStudent.get(4), "NotDel")
                        && Objects.equals(arrayStudent.get(1), firstName)
                        && Objects.equals(arrayStudent.get(2), mLastName)) {
                    return new Student(Integer.parseInt(arrayStudent.get(0)), arrayStudent.get(1),
                            arrayStudent.get(2), arrayStudent.get(3));
                }
            }
            throw new Exception("Такого пользователя не существует");
        }

        /**
         * Удаляет студента, если таковой существует
         * Из файла не удаляется, лишь меняется флаг
         * @param id
         * @throws Exception
         */
        public static void DeleteStudentById(Integer id) throws Exception {
            var file = CheckFile();
            var scannerFile = new Scanner(file);

            while (scannerFile.hasNextLine()) {
                var string = scannerFile.nextLine();
                var arrayStudent = Arrays.asList(string.split(" "));

                if (Objects.equals(arrayStudent.get(0), id.toString())) {
                    arrayStudent.set(4, "Del");
                    return;
                }
            }
            throw new Exception("Такого пользователя не существует");
        }

        /**
         * Проверяет наличие файла, если нет, то создаёт его
         * @return Возвращает объект типа File
         */
        public static @NotNull File CheckFile() {
            var file = new File("src/checkingForCheating/files", "students.txt");

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    System.out.println("Ошибка создания файла!");
                }
            }
            return file;
        }
    }
}
