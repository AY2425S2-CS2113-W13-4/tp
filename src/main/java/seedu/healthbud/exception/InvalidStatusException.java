package seedu.healthbud.exception;

public class InvalidStatusException extends Exception {
    public InvalidStatusException() {
        super("Invalid status command - status change <cutting/bulking> or status report <date>");
    }
}
