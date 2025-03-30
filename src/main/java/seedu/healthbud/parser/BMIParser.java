package seedu.healthbud.parser;

import seedu.healthbud.command.InputOnly.BMICommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidBMIException;

public class BMIParser {

    public static BMICommand parse(String input) throws HealthBudException, InvalidBMIException {
        assert input != null && !input.trim().isEmpty() : "Input should not be null or empty";

        if (!input.contains("/h") || !input.contains("/w")) {
            throw new InvalidBMIException();
        }

        String[] parts = input.trim().split("/");
        if (parts.length < 3) {
            throw new InvalidBMIException();
        }

        try {
            double weight = Double.parseDouble(parts[1].substring(1).trim()); // after 'w'
            double height = Double.parseDouble(parts[2].substring(1).trim()); // after 'h'

            if (weight <= 0 || height <= 0) {
                throw new HealthBudException("Weight and height must be greater than zero.");
            }

            return new BMICommand(input, weight, height);
        } catch (NumberFormatException e) {
            throw new HealthBudException("Invalid number format for weight or height.");
        }
    }
}
