package seedu.healthbud.exception;

public class InvalidViewException extends Exception {
    public InvalidViewException() {
        super("Invalid view command - view <date|all>");
    }
}
