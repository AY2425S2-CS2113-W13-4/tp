package seedu.healthbud.exception;

public class InvalidCardioException extends RuntimeException {
    public InvalidCardioException() {
        super("Invalid cardio log command - add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <date>");
    }
}
