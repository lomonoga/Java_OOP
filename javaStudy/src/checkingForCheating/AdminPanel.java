package checkingForCheating;

public class AdminPanel {
    /**
     * Позволяет добавить студента в программу
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param university Институт студента
     */
    public void AddStudent(String firstName, String lastName, String university) throws Exception {
        new Student(firstName, lastName, university).AddStudent();
    }

    /**
     * Позволяет удалить студента из программы
     * Дописывается параметр, что студент удалён, но по сути не удаляет из файла
     * @param firstName Имя студента
     * @param lastName Фамилия студента
     * @param university Институт студента
     */
    public void DeleteStudent(String firstName, String lastName, String university) throws Exception {
        var student = Student.StudentStatic.FindNotDeleteStudentByName(firstName, lastName);
        Student.StudentStatic.DeleteStudentById(student.id);
    }

}
