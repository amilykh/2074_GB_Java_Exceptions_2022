public class AlphaException extends Exception {
    String message;

    AlphaException(String str) {
        message = str;
    }

    public String toString() {
        return ("AlphaException occured: " + message);
    }
}
