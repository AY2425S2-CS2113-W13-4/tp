package seedu.healthbud.exception;

public class InvalidLogException extends Exception {
    public InvalidLogException() {
        super("Invalid log input - add <pb|meal|workout|water>");
    }
}
