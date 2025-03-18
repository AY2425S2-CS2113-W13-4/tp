package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException(String message) {
        super(message);
    }

    public InvalidWorkoutException() {
        super("Invalid workout details provided.");
    }
}