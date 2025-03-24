package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid workout log command - add workout <exercise> /r <reps> /s <sets> /d <date>");
    }
}
