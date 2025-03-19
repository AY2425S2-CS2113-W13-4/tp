package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.Test;
//import seedu.healthbud.storage.Storage;

public class AddLogCommand extends Command {

    @Override
    public void execute(LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws InvalidMealException, InvalidWorkoutException {

        String[] parts = input.trim().split(" ");

        assert parts.length > 2 : "Invalid add command input";

        if (parts.length < 2) {
            Ui.printMessage("Invalid add command input");
            return;
        }

        assert parts[1].matches("meal|workout|water") : "Invalid log type";

        switch (parts[1]) {
        case "water":
            //`Ui.printMessage(" feature not implemented yet");
            assert input != null : "Invalid water input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";

            if (!input.contains("/ml") || !input.contains("/d") || !input.contains("/t")) {
                throw new InvalidWaterException();
            }

            String[] water = input.substring(3).split("/");

            water[1] = water[1].substring(3).trim();
            water[2] = water[2].substring(1).trim();
            water[3] = water[3].substring(1).trim();

            if (water[1].isEmpty() || water[2].isEmpty() || water[3].isEmpty()) {
                throw new InvalidWaterException();
            }

            water[0] = water[0].trim();
            water[0] = water[0].substring(0,1).toUpperCase() + water[0].substring(1);

            Water newWater = new Water(water[0].trim(), water[1], water[2], water[3]);

            waterLogs.addLog(newWater);
            Ui.printMessage(" Got it. I've added this water log:");

            Ui.printMessage(" Type: " + waterLogs.getLog(waterLogs.getSize() - 1));
            Ui.printMessage(" Now you have " + waterLogs.getSize() + " water logs in the list.");
            break;


        case "workout":

            //Ui.printMessage(" feature not implemented yet");

            if (!input.contains("/e") || !input.contains("/r") || !input.contains("/s")) {
                throw new InvalidWorkoutException();
            }

            String[] workout = input.substring(8).split("/");

            if (workout.length != 5) {
                throw new InvalidMealException();
            }

            workout[1] = workout[1].substring(3).trim();
            workout[2] = workout[2].substring(1).trim();
            workout[3] = workout[3].substring(1).trim();

            if (workout[1].isEmpty() || workout[2].isEmpty() || workout[3].isEmpty()) {
                throw new InvalidMealException();
            }

            Test newWorkout = new Test(workout[0].trim(), workout[1], workout[2], workout[3]);

            workoutLogs.addLog(newWorkout);

            Ui.printMessage(" Got it. I've added this workout:");
            Ui.printMessage("   " + mealLogs.getLog(mealLogs.getSize() - 1));
            // TO BE DONE Storage.appendMealToFile(newMeal);
            Ui.printMessage(" Now you have " + mealLogs.getSize() + " workout done.");
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
            //Storage.appendMealToFile(newMeal);
            Ui.printMessage(" Now you have " + mealLogs.getSize() + " meals in the list.");
            break;
            
        default:
            Ui.printMessage("Invalid type of log");
        }
    }
}
