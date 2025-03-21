package seedu.healthbud.exception;

public class InvalidSumException extends Exception {
    public InvalidSumException() {
        super("Invalid sum command eg. sum <cal|vol> /d <date>");
    }
}
