package seedu.healthbud.exception;

public class  InvalidBMIException extends Exception {
    public InvalidBMIException() {
        super("Invalid BMI command. (e.g., bmi /w 68 <in_kg> /h 1.77 <height_in_m>)");
    }
}

