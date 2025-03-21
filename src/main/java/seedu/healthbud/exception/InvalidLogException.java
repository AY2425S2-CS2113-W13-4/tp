package seedu.healthbud.exception;

public class InvalidLogException extends Exception {
    public InvalidLogException() {
        super("Invalid log input (e.g., add <pb|meal|workout|water>)");
    }
}
