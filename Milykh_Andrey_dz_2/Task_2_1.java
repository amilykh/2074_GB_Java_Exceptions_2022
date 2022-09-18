import java.util.InputMismatchException;
import java.util.Scanner;

/*
1) Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 (типа float), и возвращает введенное значение. Ввод текста вместо числа
 не должно приводить к падению приложения, вместо этого, необходимо повторно
 запросить у пользователя ввод данных.
 */
public class Task_2_1 {
    public static float  giveMeSomething() {
        System.out.println(("Введите дробное число с плавающей запятой(тип float): "));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException ex) {
                System.out.println("Неверный ввод! Попробуйте вести число с плавающей запятой (float) ещё раз: ");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(giveMeSomething());
    }
}
