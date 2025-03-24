package seedu.healthbud;

import seedu.healthbud.command.SumCommand;
import seedu.healthbud.command.ClearCommand;
import seedu.healthbud.command.DeleteCommand;
import seedu.healthbud.command.FindCommand;
import seedu.healthbud.command.RecommendCommand;
import seedu.healthbud.command.BMICommand;
import seedu.healthbud.command.AddLogCommand;
import seedu.healthbud.command.ListCommand;
import seedu.healthbud.command.ViewCommand;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.exception.InvalidClearException;
import seedu.healthbud.exception.InvalidDeleteException;
import seedu.healthbud.exception.InvalidFindException;
import seedu.healthbud.exception.InvalidListException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.InvalidSumException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidViewException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidMLException;


public class Parser {

    public static final String NEW_LINE = "\n     ";


    public static boolean handleInput(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList cardioLogs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "add":
                new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                new ListCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "recommend":
                new RecommendCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "bmi":
                new BMICommand(input).execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "find":
                new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "delete":
                new DeleteCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "clear":
                new ClearCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "sum":
                new SumCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            case "view":
                new ViewCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidMealException | InvalidRecommendException | InvalidBMIException | HealthBudException |
                 InvalidLogException | InvalidWaterException | InvalidWorkoutException | InvalidListException |
                 InvalidFindException | InvalidDeleteException | InvalidPBException | InvalidClearException |
                 InvalidSumException | InvalidViewException
                 | InvalidCardioException | InvalidMLException | InvalidGoalException e) {

            System.out.println(e.getMessage());
        }
        return true;
    }
}
