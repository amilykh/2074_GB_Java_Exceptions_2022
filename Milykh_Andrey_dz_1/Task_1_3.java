import java.util.Arrays;

/*
3) Реализуйте метод, принимающий  в качестве аргументов два целочисленных
массива, и возвращающий новый массив, каждый которого равен разности элементов
двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
как-то оповестить пользователя.
 */
public class Task_1_3 {
    public static int[] subtracting_array_elements(int[] arr_1, int[] arr_2){
        if(arr_1.length != arr_2.length) {
            throw new RuntimeException("Длины массивов не равны!");
        } else {
            int count = arr_1.length;
            int[] result_arr = new int[count];
            for (int i = 0; i < count; i++) {
                result_arr[i] = arr_1[i] - arr_2[i];
            }
            return result_arr;
        }
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[] {6, 7, 8, 9};
        int[] nums_2 = new int[] {1, 2, 3, 4, 5};

        int[] result_arr = subtracting_array_elements(nums_1, nums_2);
        System.out.print("Содержимое массива result_arr: ");
        System.out.println(Arrays.toString(result_arr));
    }
}
