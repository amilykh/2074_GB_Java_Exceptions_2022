public class GenderException extends Exception {
    String message;

    GenderException(String str) {
        message = str;
    }


    public String toString() {
            return ("GenderException occured: " + message);
        }
}
