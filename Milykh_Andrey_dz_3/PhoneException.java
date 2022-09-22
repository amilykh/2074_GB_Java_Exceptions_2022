public class PhoneException extends Exception {
    String message;

    PhoneException(String str) {
        message = str;
    }

    public String toString() {
        return ("PhoneException occured: " + message);
    }
}
