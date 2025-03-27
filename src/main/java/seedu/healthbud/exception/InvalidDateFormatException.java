package seedu.healthbud.exception;

import java.util.List;

public class InvalidDateFormatException extends Exception {

    public InvalidDateFormatException(String inputDate, List<String> validFormats) {
        super("Could not parse date: " + inputDate +
                ". try other formats: " + validFormats);
    }
}
