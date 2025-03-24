package seedu.healthbud.exception;

public class InvalidMLException extends RuntimeException {
    public InvalidMLException() {
        super("Invalid water volume inputted, please input a valid number (e.g., 250, 1000, 1250)");
    }
}
