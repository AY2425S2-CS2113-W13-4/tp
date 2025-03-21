package seedu.healthbud.exception;

public class InvalidClearException extends RuntimeException {
    public InvalidClearException() {
        super("Invalid clear command eg. clear <pb|meal|workout|water>");
    }
}
