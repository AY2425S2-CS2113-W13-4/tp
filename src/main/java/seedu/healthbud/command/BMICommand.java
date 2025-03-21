package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidBMIException;

public class BMICommand extends Command{
    private double weight; // in kilograms
    private double height; // in meters

    // Constructor
    public BMICommand(String input) throws HealthBudException, InvalidBMIException {
        assert input != null && !input.trim().isEmpty() : "Input must be provided for BMI command";

        if (!input.contains("/h") || !input.contains("/w")) {
            throw new InvalidBMIException();
        }

        String[] parts = input.split("/");
        parts[1] = parts[1].substring(1).trim();
        parts[2] = parts[2].substring(1).trim();

        try{
            this.weight = Double.parseDouble(parts[1]);
            this.height = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e){
            throw new HealthBudException("Invalid number format for weight or height.");
        }

        if (weight <= 0 || height <= 0) {
            throw new HealthBudException("Please ensure both height and weight are positive values greater than zero.");
        }
    }

    @Override
    public void execute(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input){
        double bmi = weight / (height * height);
        Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi));
    }
}
