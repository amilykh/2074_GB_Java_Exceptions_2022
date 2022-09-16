/*
 2) Посмотрите на код,  и подумайте сколько разных типов исключений вы тут
 сможете получить
 */
public class Task_1_2 {
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] strings = new String[][]
                {
                        {"10", "11", "12", "13", "14"},
                        {"15", "16", "17", "18", "19"},
                        {"20", "21", "22", "23", "24"}
                };
        System.out.println(sum2d(strings));  // out: 255
    }
}
/*
{ 10, "11", "12", "13", "14"},
{"15", "16", "17", "18", "19"},
{"20", "21", "22", "23", "24"}

E:\projects\Java\ExceptionsHomeworks\dz_1\src\Task_1_2.java:20:26
java: incompatible types: int cannot be converted to java.lang.String
 */

/*
{"10", "11", null, "13", "14"},
{"15", "16", "17", "18", "19"},
{"20", "21", "22", "23", "24"}

Exception in thread "main" java.lang.NumberFormatException: Cannot parse null string
	at java.base/java.lang.Integer.parseInt(Integer.java:630)
	at java.base/java.lang.Integer.parseInt(Integer.java:784)
	at Task_1_2.sum2d(Task_1_2.java:10)
	at Task_1_2.main(Task_1_2.java:24)
 */

/*
{"10", "11", "12", "13", "test"},
{"15", "16", "17", "18", "19"},
{"20", "21", "22", "23", "24"}
Exception in thread "main" java.lang.NumberFormatException: For input string: "test"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:668)
	at java.base/java.lang.Integer.parseInt(Integer.java:784)
	at Task_1_2.sum2d(Task_1_2.java:10)
	at Task_1_2.main(Task_1_2.java:24)
 */

/*
{"10", "11", "12", "13", "14"},
{"15.6", "16", "17", "18", "19"},
{"20", "21", "22", "23", "24"}

Exception in thread "main" java.lang.NumberFormatException: For input string: "15.6"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:668)
	at java.base/java.lang.Integer.parseInt(Integer.java:786)
	at Task_1_2.sum2d(Task_1_2.java:10)
	at Task_1_2.main(Task_1_2.java:24)
 */
