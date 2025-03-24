package seedu.healthbud.exception;

public class  InvalidMealException extends Exception {
    public InvalidMealException() {
        super("Invalid meal log command - add meal <meal_name> /cal <calories> /d <date> /t <time>");
    }
}
