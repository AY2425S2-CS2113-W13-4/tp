package seedu.healthbud.exception;

public class InvalidPBException extends RuntimeException {
    public InvalidPBException() {
        super("Invalid pb log command - add pb <exercise> /w <weight_in_kg> /d <date>");
    }
}
