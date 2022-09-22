import java.util.Arrays;
import java.util.List;

public class CheckBirthday {
    private static String birthday;


    CheckBirthday(String str) {
        birthday = str;
    }

    public String getBirthday() {
        return birthday;
    }

    boolean isDate()
    {
        return checkDate(getBirthday());
    }

    public static boolean checkDate(String input) {
        String dateDelimiter = "\\.";
        String[] dateFields = input.split(dateDelimiter);
        int day;
        int month;
        int year;
        try {
            day = Integer.parseInt(dateFields[0].strip());
            month = Integer.parseInt(dateFields[1].strip());
            year = Integer.parseInt(dateFields[2].strip());
        } catch (Exception ex) {
            return false;
        }

        List<Integer> bigMonthList = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> smallMonthList = Arrays.asList(4, 6, 9, 11);

        if (month == 2) {
            if (year % 4 == 0) {  // високосный год в феврале
                if (day > 0 && day < 30) {
                    return true;
                }
            } else {  // обычный февраль
                if (day > 0 && day < 29) {
                    return true;
                }
            }
        }

        if (bigMonthList.contains(month)) {  // большой месяц
            return day > 0 && day < 32;
        } else if (smallMonthList.contains(month)) {  // обычный месяц
            return day > 0 && day < 31;
        }

        return false;
    }
}
