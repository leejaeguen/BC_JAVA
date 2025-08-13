package section02.exception;

public class MoneyNegativeException extends Exception {
    public MoneyNegativeException(String message) {
        super(message);
    }
}
