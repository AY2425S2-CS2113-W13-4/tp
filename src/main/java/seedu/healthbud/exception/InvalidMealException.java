package seedu.healthbud.exception;

public class  InvalidMealException extends Exception {
    public InvalidMealException() {
        super("Invalid meal command (e.g., meal chicken rice /cal 550 /d 12-01-25 /t 9pm)");
    }
}
