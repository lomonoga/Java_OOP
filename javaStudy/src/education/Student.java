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
}
