package seedu.healthbud.exception;

public class InvalidViewException extends Exception {
    public InvalidViewException() {
        super("Invalid view command - Try view /m <logtype> /d <date>, at least one " +
                "must be provided." +
                "OR, view /m all");
    }
}
