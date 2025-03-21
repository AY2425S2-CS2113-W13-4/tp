package seedu.healthbud.exception;

public class InvalidWaterException extends Exception {
    public InvalidWaterException() {
        super("Invalid water log command (e.g., add water /ml 500 /d 12-01-25 /t 9pm)");
    }
}
