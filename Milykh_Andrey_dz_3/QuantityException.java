public class QuantityException extends Exception {
    String message;

    QuantityException(String str) {
        message = str;
    }

    public String toString() {
        return ("QuantityException occured: " + message);
    }
}
