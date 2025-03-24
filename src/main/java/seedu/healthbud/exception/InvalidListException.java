package seedu.healthbud.exception;

public class InvalidListException extends Exception {
    public InvalidListException() {
        super("Invalid list command - list <pb|meal|workout|water|cardio>");
    }
}
