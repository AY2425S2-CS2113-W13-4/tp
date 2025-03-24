package seedu.healthbud.exception;

public class InvalidSumException extends Exception {
    public InvalidSumException() {
        super("Invalid sum command - sum <cal|vol> /d <date>");
    }
}
