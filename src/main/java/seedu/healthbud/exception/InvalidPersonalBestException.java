package seedu.healthbud.exception;

public class InvalidPersonalBestException extends RuntimeException {
    public InvalidPersonalBestException() {
        super("Invalid pb log command - add pb <exercise> /w <weight_in_kg> /d <date>");
    }
}
