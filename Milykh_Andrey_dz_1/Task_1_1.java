/*
 1) Реализуйте 3 метода,  чтобы в каждом из них получить разные исключения
 */
public class Task_1_1 {
    public static int division(int var_1, int var_2) {
        return var_1 / var_2;
    }

    public static void print(int[] test_array, int index) {
        System.out.println(test_array[index]);
    }

    public static int addition(Integer var_1, Integer var_2) {
        return var_1 + var_2;
    }

    public static void main(String[] args) {
        int result = division(5, 0);
        System.out.println(result);

        int[] nums = new int[] {1, 2, 3, 4, 5};
        print(nums,6);

        Integer a = null;
        Integer b = 2;
        System.out.println(addition(a, b));
    }
}
/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Task_1_1.division(Task_1_1.java:6)
	at Task_1_1.main(Task_1_1.java:18)
 */

/*
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
	at Task_1_1.print(Task_1_1.java:10)
	at Task_1_1.main(Task_1_1.java:22)
 */

/*
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "var_1" is null
	at Task_1_1.addition(Task_1_1.java:14)
	at Task_1_1.main(Task_1_1.java:26)
 */
