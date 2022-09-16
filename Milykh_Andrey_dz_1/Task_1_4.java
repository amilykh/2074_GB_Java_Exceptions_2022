import java.util.Arrays;

/*
4) Реализуйте метод, принимающий в качестве аргументов два целочисленных
массива, и возвращающий новый массив, каждый элемент которого равен частному
элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
необходимо как-то оповестить пользователя. Важно: При выполнении метода
единственное исключение, которое пользователь может увидеть - RuntimeException,
 т.е. ваше.
 */
public class Task_1_4 {
    public static double[] division_array_elements(int[] arr_1, int[] arr_2){
        if(arr_1.length != arr_2.length) {
            throw new RuntimeException("Длины массивов не равны!");
        } else {
            int count = arr_1.length;
            double[] quotient_arr = new double[count];
            for (int i = 0; i < count; i++) {
                if (arr_2[i] == 0) {
                    throw new RuntimeException("Нелья делить на 0");
                }
                quotient_arr[i] = arr_1[i] * 1.0 / arr_2[i];
            }
            return quotient_arr;
        }
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[] {6, 7, 8, 9, 10};
        int[] nums_2 = new int[] {1, 2, 0, 4, 5};

        double[] result_arr = division_array_elements(nums_1, nums_2);
        System.out.print("Содержимое массива result_arr: ");
        System.out.println(Arrays.toString(result_arr));
    }
}
