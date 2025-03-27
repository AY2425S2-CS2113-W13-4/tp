package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.WorkOUT;
import seedu.healthbud.log.PB;
import seedu.healthbud.log.Goals;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.ParserParameters;

import java.util.Map;
import java.util.Scanner;

public class AddLogCommand extends Command {

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input)
            throws InvalidMealException, InvalidWorkoutException, InvalidWaterException, InvalidLogException,
            InvalidPBException, InvalidMLException, InvalidCardioException, InvalidGoalException {


        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidLogException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        switch (command) {

        case "goal":
            Ui.printMessage("Welcome to Goal Setting! \n");
            Ui.printMessage("Here are your current goals:\n" + "\n" + Goals.getInstance());
            Ui.printMessage("To change a goal please enter /name + value, " +
                    "/w for Water Goal, /c for Calorie Goal, /m for Weight Goal\n");
            Ui.printMessage("To check your progress, type 'progress'!");
            Ui.printMessage("To exit goal setting, type 'exit'!");
            Scanner in = new Scanner(System.in);
            Goals goal = Goals.getInstance();
            LogList logList = new LogList();

            String change = in.nextLine().trim();
            while (!change.contains("exit")) {

                if (change.contains("/w")) {

                    goal.setDailyWaterGoal(change.substring(3));
                    Ui.printMessage("Water Goal has been updated to " + goal.getDailyWaterGoal());
                } else if (change.contains("/c")) {

                    goal.setDailyCalorieGoal(change.substring(3));
                    Ui.printMessage("Calorie Goal has been updated to " + goal.getDailyCalorieGoal());
                } else if (change.contains("/m")) {

                    goal.setWeightGoal(change.substring(3));
                    Ui.printMessage("Weight Goal has been updated to " + goal.getWeightGoal());
                } else if (change.contains("progress")) {
                    Ui.printMessage("Which day would you like to view?");
                    logList.getAllDates();
                    String prog = in.nextLine().trim();
                    try {
                        Ui.printMessage("Here is your progress for " + prog + ":\n");
                        waterLogs.getWaterSum(prog);
                        mealLogs.getCaloriesSum(prog);
                        goal.getWeeklyWeightProgress();
                    } catch (InvalidDateException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    throw new InvalidGoalException();
                }
                change = in.nextLine().trim();
            }
            Ui.printMessage("Exited Goal Setting");
            break;

        case "pb":

            if (!input.contains("/w ") || !input.contains("/d ")) {
                throw new InvalidPBException();
            }

            input = input.substring("add pb".length()).trim();

            String pbName = input.substring(0, input.indexOf("/")).trim();

            if (pbName.isEmpty() || param.get("w").isEmpty() || param.get("d").isEmpty()) {
                throw new InvalidPBException();
            }

            if (!param.get("w").matches("\\d+")) {
                throw new InvalidPBException();
            }

            PB newPB = new PB(pbName, param.get("w"), param.get("d"));
            pbLogs.addLog(newPB);
            break;

        case "water": // bottle 1000 /glass 250
            assert input != null : "Invalid water input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";

            if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ")) {
                throw new InvalidWaterException();
            }

            input = input.substring("add water".length()).trim();

            if (param.get("ml").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()) {
                throw new InvalidWaterException();
            }

            if (!param.get("ml").matches("\\d+")) {
                throw new InvalidWaterException();
            }

            Water newWater = new Water(param.get("ml"), param.get("d"), param.get("t"));
            waterLogs.addLog(newWater);
            break;

        case "workout":

            assert input != null : "Invalid workout input!";

            if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ")) {
                throw new InvalidWorkoutException();
            }

            input = input.substring("add workout".length()).trim();

            String workoutName = input.substring(0, input.indexOf("/")).trim();

            if (param.get("r").isEmpty() || param.get("s").isEmpty() || param.get("d").isEmpty()
                    || workoutName.isEmpty()) {
                throw new InvalidWorkoutException();
            }

            if (!param.get("r").matches("\\d+") || !param.get("s").matches("\\d+")) {
                throw new InvalidWaterException();
            }

            WorkOUT newWorkout = new WorkOUT(workoutName, param.get("r"), param.get("s"), param.get("d"));
            workoutLogs.addLog(newWorkout);
            break;

        case "meal":

            if(!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
                throw new InvalidMealException();
            }

            input = input.substring("add meal".length()).trim();

            String mealName = input.substring(0, input.indexOf("/")).trim();

            if (param.get("cal").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()
                    || mealName.isEmpty()) {
                throw new InvalidMealException();
            }

            if (!param.get("cal").matches("\\d+")) {
                throw new InvalidMealException();
            }

            Meal newMeal = new Meal(mealName, param.get("cal"), param.get("d"), param.get("t"));
            mealLogs.addLog(newMeal);
            break;

        case "cardio":
            assert input != null : "Invalid cardio input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";

            if (!input.contains("/s ") || !input.contains("/i ") || !input.contains("/t ") || !input.contains("/d ")) {
                throw new InvalidCardioException();
            }

            input = input.substring("add cardio".length()).trim();

            String cardioName = input.substring(0, input.indexOf("/")).trim();

            if (cardioName.isEmpty() || param.get("s").isEmpty() || param.get("i").isEmpty()
                    || param.get("t").isEmpty() || param.get("d").isEmpty()) {
                throw new InvalidCardioException();
            }

            if (!param.get("s").matches("\\d+") || !param.get("i").matches("\\d+") ||
                    !param.get("t").matches("\\d+")) {
                throw new InvalidCardioException();
            }

            Cardio newCardio = new Cardio(cardioName, param.get("s"), param.get("i"), param.get("t"),
                    param.get("d"));

            cardioLogs.addLog(newCardio);
            break;

        default:
            Ui.printMessage("Invalid type of log");
        }
    }

}
