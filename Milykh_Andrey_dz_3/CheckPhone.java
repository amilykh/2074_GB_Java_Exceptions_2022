public class CheckPhone {
    private static String phone;

    CheckPhone(String str) {
        phone = str;
    }

    public String getPhone() {
        return phone;
    }

    boolean isNumeric() {
        String regex = "\\d+";
        return getPhone().matches(regex);
    }
}
