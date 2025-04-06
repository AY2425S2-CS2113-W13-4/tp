package seedu.healthbud.exception;

/**
 * Exception thrown when the user inputs an invalid delete command.
 */
public class InvalidDeleteException extends Exception {
    /**
     * Constructs an InvalidDeleteException with a default error message.
     */
    public InvalidDeleteException() {
        super("Invalid delete command (e.g. delete <pb|meal|workout|water|cardio> <index>)");
    }
}
