package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.storage.Storage;


//import seedu.healthbud.log.Workout;

public class AddLogCommand extends Command {

    @Override
    public void execute(LogList mealLogs, LogList workoutLogs, String input)
            throws InvalidMealException, InvalidWorkoutException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            Ui.printMessage("Invalid input");
            return;
        }

        switch (parts[1]) {
        case "water":
            Ui.printMessage(" feature not implemented yet");
            break;

        case "workout":

            Ui.printMessage(" feature not implemented yet");

//            if (!input.contains("/e") || !input.contains("/r") || !input.contains("/s")) {
//                throw new InvalidWorkoutException();
//            }
//
//            String[] workout = input.substring(8).split("/");
//
//            if (workout.length != 4) {
//                throw new InvalidMealException();
//            }
//
//            workout[1] = workout[1].substring(3).trim();
//            workout[2] = workout[2].substring(1).trim();
//            workout[3] = workout[3].substring(1).trim();
//
//            if (workout[1].isEmpty() || workout[2].isEmpty() || workout[3].isEmpty()) {
//                throw new InvalidMealException();
//            }
//
//            Workout newWorkout = new Workout(workout[0].trim(), workout[1], workout[2], workout[3]);
//
//            workoutLogs.addLog(newWorkout);
//
//            Ui.printMessage(" Got it. I've added this workout:");
//            Ui.printMessage("   " + mealLogs.getLog(mealLogs.getSize() - 1));
//            // TO BE DONE Storage.appendMealToFile(newMeal);
//            Ui.printMessage(" Now you have " + mealLogs.getSize() + " workout done.");
            break;

        case "meal":
            if (!input.contains("/d") || !input.contains("/t") || !input.contains("/cal")) {
                throw new InvalidMealException();
            }

            String[] meal = input.substring(8).split("/");

            if (meal.length != 4) {
                throw new InvalidMealException();
            }

            meal[1] = meal[1].substring(3).trim();
            meal[2] = meal[2].substring(1).trim();
            meal[3] = meal[3].substring(1).trim();

            if (meal[1].isEmpty() || meal[2].isEmpty() || meal[3].isEmpty()) {
                throw new InvalidMealException();
            }

            Meal newMeal = new Meal(meal[0].trim(), meal[1], meal[2], meal[3]);
            mealLogs.addLog(newMeal);

            Ui.printMessage(" Got it. I've added this meal:");
            Ui.printMessage("   " + mealLogs.getLog(mealLogs.getSize() - 1));
            Storage.appendMealToFile(newMeal);
            Ui.printMessage(" Now you have " + mealLogs.getSize() + " meals in the list.");
            break;
            
        default:
            Ui.printMessage("Invalid type of log");
        }
    }
}
