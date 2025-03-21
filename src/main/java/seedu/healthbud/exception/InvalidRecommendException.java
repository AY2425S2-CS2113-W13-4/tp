package seedu.healthbud.exception;

public class InvalidRecommendException extends Exception {
    public InvalidRecommendException() {
        super("Invalid excercise recommend command (e.g., recommend biceps)");
    }
}
