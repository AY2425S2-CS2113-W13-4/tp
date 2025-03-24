package seedu.healthbud.exception;

public class InvalidDeleteException extends Exception {
    public InvalidDeleteException() {
        super("Invalid delete command - delete <meal|workout|water|pb> <index>");
    }
}
