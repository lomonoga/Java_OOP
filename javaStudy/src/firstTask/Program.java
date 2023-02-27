package firstTask;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        authorization();
        printSineTable(45);
    }

    public static void authorization(){
        System.out.print("Введите ваше Имя: ");
        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        if (!Objects.equals(name, "")) {
            System.out.println("Здравствуйте, " + name + "!");
        }
        else {
            System.out.println("Вы захотели остаться анонимным? Хорошо, мы уважаем наших клиентов");
        }
    }

    public static void printSineTable(int endAngle){
        var indentAngle = "      ";
        var indentSine = "    ";
        System.out.print("Угол:");
        for (var angle = 0; angle <= endAngle; angle += 5){
            System.out.print(indentAngle + angle);
        }

        System.out.print("\nСинус: ");
        var decimalFormat = new DecimalFormat( "#.##" );
        for (var angle = 0; angle <= endAngle; angle += 5){
            var sine = decimalFormat.format(java.lang.Math.sin(java.lang.Math.toRadians(angle)));
            System.out.print(indentSine + sine);
        }
    }
}
