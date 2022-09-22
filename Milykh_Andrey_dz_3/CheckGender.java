public class CheckGender {

    private static String gender;

    CheckGender(String str) {
        gender = str;
    }

    public String getGender() {
        return gender;
    }

    boolean isGender() {
        String regex = "[fm]";
        return getGender().matches(regex);
    }
}
