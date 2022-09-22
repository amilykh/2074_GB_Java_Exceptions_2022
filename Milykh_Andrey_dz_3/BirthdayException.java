public class BirthdayException extends Exception {
    String message;

    BirthdayException(String str) {
        message = str;
    }

    public String toString() {
        return ("BirthdayException occured: " + message);
    }
}
