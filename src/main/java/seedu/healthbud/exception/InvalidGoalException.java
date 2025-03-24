package seedu.healthbud.exception;

public class InvalidGoalException extends RuntimeException {
    public InvalidGoalException() {
        super("Invalid Goal command. To change a goal, please enter /goalcode + value (e.g. /w 1000)");
    }
}
