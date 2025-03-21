package seedu.healthbud.exception;

public class InvalidMLException extends RuntimeException {
    public InvalidMLException() {
        super("Invalid water volume inputted, please input a valid number (eg, 250, 1000, 1250)");
    }
}
