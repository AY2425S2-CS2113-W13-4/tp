package seedu.healthbud.exception;

public class InvalidClearException extends RuntimeException {
    public InvalidClearException() {
        super("Invalid clear command - clear <pb|meal|workout|water>");
    }
}
