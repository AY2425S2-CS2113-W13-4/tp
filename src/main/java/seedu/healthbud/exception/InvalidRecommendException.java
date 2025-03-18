package seedu.healthbud.exception;

public class InvalidRecommendException extends Exception {
    public InvalidRecommendException() {
        super("Invalid workout recommend command (e.g., recommend biceps)");
    }
}
