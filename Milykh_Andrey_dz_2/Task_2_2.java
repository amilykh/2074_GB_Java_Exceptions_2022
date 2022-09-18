/*
2) Если необходимо, исправьте данный код
try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}
 */
public class Task_2_2 {
    public static void main(String[] args) {
        System.out.println("Начало программы");

        try {
            int[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            int d = 0;
            double  catchedRes1;
            if (d != 0) {
                catchedRes1 = (float)intArray[8]  / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } else {
                catchedRes1 = intArray[8] / d;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексациии массива: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

        System.out.println("Конец программы");
    }
}
