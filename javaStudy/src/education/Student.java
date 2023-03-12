package education;

import firstTask.MyException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;

    public Student(String firstName, String lastName, String patronymic, int year, int month, int date) throws MyException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;

        try {
            var birthDateExc = LocalDate.of(year, month, date);
            if (birthDateExc.isAfter(LocalDate.now()))
                throw new MyException("Этот студент ещё не родился даже!");
            else
                this.birthDate = birthDateExc;
        }
        catch (DateTimeException e) {
            throw new MyException("Введите корректную дату");
        }
    }

    private Student(StudentBuilder studentBuilder) {
        this.birthDate = studentBuilder.birthDate;
    }

    /**
     * The method returns Full Name of Student
     * Return value type HashMap with 3 key-values:
     * "firstName" : firstName of Student
     * "lastName" : lastName of Student
     * "patronymic" : patronymic of Student
     * */
    public HashMap getFullName(){
        return new HashMap<String, String>(){{
            put("firstName", firstName);
            put("lastName", lastName);
            put("patronymic", patronymic);
        }};
    }

    /**
     * The method returns student age
     * Return value type int
     * */
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static class StudentBuilder {
        private String firstName; //optional
        private String lastName; //optional
        private String patronymic; //optional
        private LocalDate birthDate;

        public StudentBuilder(int year, int month, int date) throws Exception {
            try {
                var birthDateExc = LocalDate.of(year, month, date);
                if (birthDateExc.isAfter(LocalDate.now()))
                    throw new MyException("Этот студент ещё не родился даже!");
                else
                    this.birthDate = birthDateExc;
            }
            catch (DateTimeException e) {
                throw new MyException("Введите корректную дату");
            }
        }

        /**
         * set full Name of Student
         * @param firstName
         * @param lastName
         * @param patronymic
         */
        public StudentBuilder setFullNameStudent(String firstName, String lastName, String patronymic) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.patronymic = patronymic;
            return this;
        }

        /**
         * Build the Student object
         */
        public Student build() {
            return new Student(this);
        }
    }
}
