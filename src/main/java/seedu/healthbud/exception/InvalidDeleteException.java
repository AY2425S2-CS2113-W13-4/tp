package seedu.healthbud.exception;

public class InvalidDeleteException extends Exception {
    public InvalidDeleteException() {
        super("Invalid delete command (e.g. delete <meal|workout|water|pb> <index>)");
    }
}
