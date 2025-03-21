package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid workout log command (e.g., add workout <exercise> /r <reps> /s <sets> /d <date>)");
    }
}
