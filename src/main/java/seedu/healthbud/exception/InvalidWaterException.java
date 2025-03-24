package seedu.healthbud.exception;

public class InvalidWaterException extends Exception {
    public InvalidWaterException() {
        super("Invalid water log command - add water /ml <volume> /d <date> /t <time>");
    }
}
