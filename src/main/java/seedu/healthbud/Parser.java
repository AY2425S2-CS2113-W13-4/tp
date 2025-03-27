package seedu.healthbud;


import seedu.healthbud.command.StatusCommand;
import seedu.healthbud.command.SumCommand;
import seedu.healthbud.command.ClearCommand;
import seedu.healthbud.command.DeleteCommand;
import seedu.healthbud.command.FindCommand;
import seedu.healthbud.command.RecommendCommand;
import seedu.healthbud.command.BMICommand;
import seedu.healthbud.command.ListCommand;
import seedu.healthbud.command.ViewCommand;
import seedu.healthbud.command.add.AddCardioCommand;
import seedu.healthbud.command.add.AddMealCommand;
import seedu.healthbud.command.add.AddPersonalBestCommand;
import seedu.healthbud.command.add.AddWaterCommand;
import seedu.healthbud.command.add.AddWorkoutCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.exception.InvalidClearException;
import seedu.healthbud.exception.InvalidDeleteException;
import seedu.healthbud.exception.InvalidFindException;
import seedu.healthbud.exception.InvalidListException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.InvalidStatusException;
import seedu.healthbud.exception.InvalidSumException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidViewException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidMLException;


public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList cardioLogs, String input) throws HealthBudException {
        String[] parts = input.split(" ");

        try {
            switch (parts[0]) {
            case "bye":
                return Ui.printGoodbye();
            case "add":
                if (parts.length < 2) {
                    throw new InvalidLogException();
                }
                switch (parts[1]) {
                case "workout":
                    new AddWorkoutCommand().execute(workoutLogs, input);
                    return true;
                case "water":
                    new AddWaterCommand().execute(waterLogs, input);
                    return true;
                case "pb":
                    new AddPersonalBestCommand().execute(pbLogs, input);
                    return true;
                case "meal":
                    new AddMealCommand().execute(mealLogs, input);
                    return true;
                case "cardio":
                    new AddCardioCommand().execute(cardioLogs, input);
                    return true;
                default:
                    throw new InvalidLogException();
                }
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
            case "status":
                new StatusCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidGoalException | InvalidViewException | InvalidCardioException | InvalidMLException
                 | InvalidBMIException | InvalidClearException | InvalidDeleteException | InvalidFindException
                 | InvalidListException | InvalidLogException | InvalidPBException | InvalidRecommendException
                 | InvalidStatusException | InvalidSumException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}

