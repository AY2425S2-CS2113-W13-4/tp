package seedu.healthbud.exception;

public class InvalidPBException extends RuntimeException {
    public InvalidPBException() {
        super("Invalid pb log command (e.g., add pb /e bench /w 200)");
    }
}
