package seedu.healthbud.exception;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
        super("Invalid date format! Please enter a valid date in the format: dd-MM-yyyy");
    }
}
