package seedu.healthbud.exception;

public class InvalidRecommendException extends Exception {
    public InvalidRecommendException() {
        super("Invalid recommend command - recommend <muscle_group>");
    }
}
