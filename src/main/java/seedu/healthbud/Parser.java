package seedu.healthbud;

import seedu.healthbud.command.AddLogCommand;
import seedu.healthbud.command.BMICommand;
import seedu.healthbud.command.ListCommand;
import seedu.healthbud.command.RecommendCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.exception.InvalidMealException;

public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "add":
                new AddLogCommand().execute(mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                new ListCommand().execute(mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "recommend":
                new RecommendCommand().execute(mealLogs, workoutLogs, waterLogs, input);
                return true;
            case "bmi":
                new BMICommand(input).execute(mealLogs, workoutLogs, waterLogs, input);
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
