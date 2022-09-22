/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные
в произвольном порядке, разделенные пробелом:

Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:

фамилия, имя, отчество - строки

дата_рождения - строка формата dd.mm.yyyy

номер_телефона - целое беззнаковое число без форматирования

пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество
не совпадает с требуемым, вернуть код ошибки, обработать его и показать
пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них
требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение,
соответствующее типу проблемы. Можно использовать встроенные типы java и создать
свои. Исключение должно быть корректно обработано, пользователю выведено
сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным
фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть
корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_3_1 {
    public static String choiceMessage = "Введите данные или 'exit' для завершения программы: ";

    public static void giveMeSomething() {
        String tmp;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные или 'exit' для завершения программы: ");
        do {
            try {
                tmp = scanner.nextLine();
                if (tmp.equals("exit")) {
                    System.out.println("Завершение программы.");
                    break;
                } else if (tmp == null || tmp.isEmpty() || tmp.equals("")) {
                    throw new IllegalArgumentException("Пустые строки вводить нельзя!");
                } else {
                    //System.out.println(tmp);
                    checkQuantity(tmp);
                }
            } catch (IllegalArgumentException ex) {
                System.err.println(ex);  // ex.printStackTrace();
                System.out.println(choiceMessage);
            }
        } while (true);
        scanner.close();
    }

    public static void checkQuantity(String str) {
        String[] subStr;
        String delimiter = " ";
        subStr = str.split(delimiter);
        int number_parameters = 6;
        try {
            if (subStr.length != number_parameters) {
                if (subStr.length > number_parameters)
                {
                    throw new QuantityException("Количество данных больше "
                            + number_parameters);
                }
                else {
                    throw new QuantityException("Количество данных меньше "
                            + number_parameters);
                }
            } else {
                try {
                    if (!isAlpha(subStr[0].strip())) {
                        throw new AlphaException("Фамилия должна содержать только символы алфавита");
                    }
                    if (!isAlpha(subStr[1].strip())) {
                        throw new AlphaException("Имя должно содержать только символы алфавита");
                    }
                    if (!isAlpha(subStr[2].strip())) {
                        throw new AlphaException("Отчество должно содержать только символы алфавита");
                    }
                    if ( !checkUserBirthday(subStr[3].strip())) {
                        throw new BirthdayException("Дата рождения введена неправильно");
                    }
                    if (!checkUserPhone(subStr[4].strip())) {  // проверка телефона)
                        throw new PhoneException("Номер телефона введён неправильно");
                    }
                    if (!checkUserGender(subStr[5].strip())) {
                        throw new GenderException("Пол пользователя введён неправильно");
                    }

                    writeData(subStr);
                    System.out.println(choiceMessage);

                } catch (BirthdayException | PhoneException |
                         GenderException | AlphaException ex) {
                    System.err.println(ex);  // e.printStackTrace();
                    System.out.println(choiceMessage);
                }
            }
        } catch (QuantityException ex) {
            System.err.println(ex);  // e.printStackTrace();
            System.out.println(choiceMessage);
        }
    }

    public static boolean checkUserBirthday(String strBirthday) {
        CheckBirthday checkBirthday = new CheckBirthday(strBirthday);
        return checkBirthday.isDate();
    }
    public static boolean checkUserPhone(String strPhone) {
        CheckPhone checkPhone = new CheckPhone(strPhone);
        return checkPhone.isNumeric();
    }

    public static boolean checkUserGender(String strGender) {
        CheckGender checkGender = new CheckGender(strGender);
        return checkGender.isGender();
    }

    public static boolean isAlpha(String s) {
        return s != null && s.chars().allMatch(Character::isLetter);
    }

    public static void writeData(String[] data)
    {
        String text = String.format("<%s><%s><%s><%s><%s><%s>"
                , data[0].strip(), data[1].strip(), data[2].strip()
                , data[3].strip(), data[4].strip(), data[5].strip()
        );

        String filePath = data[0].strip();
        File file = new File(filePath);
        if (isFileExists(file)) { // модификация файла
            try (FileWriter writer = new FileWriter((filePath), true)) {
                // запись всей строки
                writer.write("\n"+ text);
                // writer.flush();
                System.out.println("Файл " + filePath + " успешно модифицирован");
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        } else { // создание файла
            try (FileWriter writer = new FileWriter((filePath), false)) {
                writer.write(text);
                System.out.println("Файл " + filePath + " успешно создан");
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    // Метод проверки существования файла
    public static boolean isFileExists(File file) {
        return file.isFile();
    }

    public static void main(String[] args) {
        giveMeSomething();
    }
}
