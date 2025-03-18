package seedu.healthbud;

import seedu.healthbud.command.AddLogCommand;
import seedu.healthbud.command.AddWorkout;
import seedu.healthbud.command.BMI;
import seedu.healthbud.command.ListMeal;
import seedu.healthbud.command.Recommend;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.exception.InvalidMealException;

public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList logs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "meal":
                new AddLogCommand().execute(logs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                new ListMeal().execute(logs, input);
                return true;
            case "recommend":
                new Recommend().execute(logs, input);
                return true;
            case "bmi":
                new BMI(input).execute(logs, input);
                return true;
            case "add":
                new AddWorkout().execute(logs, input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidMealException | InvalidRecommendException
                 | InvalidBMIException | HealthBudException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
