/*
4) Разработайте программу, которая выбросит Exception, когда пользователь
вводит пустую строку. Пользователю должно показаться сообщение, что пустые
строки вводить нельзя.
 */
import java.util.Scanner;

public class Task_2_4 {
    public static void giveMeSomething() {
        String tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любые данные или 'exit' для завершения программы: ");
        do {
            try {
                tmp = scanner.nextLine();
                if (tmp.equals("exit")) {
                    System.out.println("Завершение программы.");
                    break;
                } else if (tmp == null || tmp.isEmpty() || tmp.equals("")) {
                    throw new IllegalArgumentException("Пустые строки вводить нельзя!");
                }
                {
                    System.out.println(tmp);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
                System.out.println("Введите любые данные или 'exit' для завершения программы: ");
            }
        } while (true);
        scanner.close();
    }

    public static void main(String[] args) {
        giveMeSomething();
    }
}
