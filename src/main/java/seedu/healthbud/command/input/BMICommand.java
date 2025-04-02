package seedu.healthbud.command.input;

import seedu.healthbud.Ui;
import seedu.healthbud.command.InputCommand;

public class BMICommand extends InputCommand {

    private final double weight; // in kilograms
    private final double height; // in meters

    public BMICommand(String input, double weight, double height) {
        //@@author Ahmish15
        super(input);
        this.weight = weight;
        this.height = height;
    }

    @Override

    public void execute() {

        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are underweight.");
        } else if (bmi < 25) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are of normal weight.");
        } else if (bmi < 30) {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are overweight.");
        } else {
            Ui.printMessage("Your BMI is: " + String.format("%.2f", bmi) + ", you are obese.");
        }
    }
}
