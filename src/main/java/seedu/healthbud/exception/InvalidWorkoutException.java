package seedu.healthbud.exception;

public class InvalidWorkoutException extends Exception {
    public InvalidWorkoutException() {
        super("Invalid workout log command - add workout <exercise> /w <weight> /r <reps> /s <sets> /d <date>");
    }
}
