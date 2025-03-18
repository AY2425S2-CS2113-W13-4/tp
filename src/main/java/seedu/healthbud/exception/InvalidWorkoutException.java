package seedu.healthbud.exception;

public class InvalidWorkoutException extends RuntimeException {
    public InvalidWorkoutException() {
        super("Invalid add command (add <date> /e <exercise> /r <reps> /s <sets>)");
    }
}
