package seedu.healthbud.exception;

public class InvalidWaterException extends RuntimeException {
    public InvalidWaterException() {
        super("Invalid water command (eg. water /ml 500 /d 12-01-25 /t 9pm)");
    }
}
