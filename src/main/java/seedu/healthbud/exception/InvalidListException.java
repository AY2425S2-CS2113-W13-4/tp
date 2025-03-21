package seedu.healthbud.exception;

public class InvalidListException extends Exception {
    public InvalidListException() {
        super("Invalid list command (e.g., list <pb|meal|workout|water>)");
    }
}
