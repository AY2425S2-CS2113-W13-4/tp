package seedu.healthbud.command;

// Imports
import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.Test;
import seedu.healthbud.log.PB;
import seedu.healthbud.storage.Storage;

public class AddLogCommand extends Command {

    @Override
    public void execute(
            LogList pbLogs,
            LogList mealLogs,
            LogList workoutLogs,
            LogList waterLogs,
            String input) throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {

            throw new InvalidLogException();
        }

        switch (parts[1]) {
        case "pb":
            if (!input.contains("/e") || !input.contains("/w") || !input.contains("/d")) {

                throw new InvalidPBException();
            }

            String[] pb = input.substring(7).split("/");
            if (pb.length != 4) {

                throw new InvalidPBException();
            }

            pb[1] = pb[1].substring(2).trim();
            pb[2] = pb[2].substring(2).trim();
            pb[3] = pb[3].substring(2).trim();
            if (pb[1].isEmpty() || pb[2].isEmpty() || pb[3].isEmpty()) {

                throw new InvalidPBException();
            }

            PB newPB = new PB(pb[1], pb[2], pb[3]);
            pbLogs.addLog(newPB);
            Ui.printMessage(" Got it. I've added this pb log:");
            Ui.printMessage("  " + pbLogs.getLog(pbLogs.getSize() - 1));
            Storage.appendLogToFile(newPB);
            Ui.printMessage(" Now you have " + pbLogs.getSize() + " pb logs in the list.");
            break;

        case "water":
            assert input != null : "Invalid water input!";
            assert !input.trim().isEmpty() : "Input should not be empty!";
            if (!input.contains("/ml") || !input.contains("/d") || !input.contains("/t")) {

                throw new InvalidWaterException();
            }

            String[] water = input.substring(10).split("/");
            if (water.length != 4) {

                throw new InvalidMealException();
            }

            if (water[1].toLowerCase().contains("bottle") || water[1].toLowerCase().contains("bottles")) {

                water[1] = water[1].substring(3).trim();
                int keyIndex = water[1].indexOf("bottle");
                try {
                    int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim());
                } catch (InvalidMLException e) {
                    System.out.println(e.getMessage());
                }
                int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim()) * 1000;
                water[1] = Integer.toString(toInteger);
            } else if (water[1].toLowerCase().contains("glass")) {

                water[1] = water[1].substring(3).trim();
                int keyIndex = water[1].indexOf("glass");
                try {
                    int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim());
                } catch (InvalidMLException e) {
                    System.out.println(e.getMessage());
                }
                int toInteger = Integer.parseInt(water[1].substring(0, keyIndex).trim()) * 250;
                water[1] = Integer.toString(toInteger);
            } else {

                water[1] = water[1].substring(3).trim();
            }

            water[2] = water[2].substring(1).trim();  // Corrected indentation
            water[3] = water[3].substring(1).trim();  // Corrected indentation

            if (water[1].isEmpty() || water[2].isEmpty() || water[3].isEmpty()) {

                throw new InvalidWaterException();
            }

            Water newWater = new Water(water[1], water[2], water[3]);
            waterLogs.addLog(newWater);
            Ui.printMessage(" Got it. I've added this water log:");
            Ui.printMessage("  " + waterLogs.getLog(waterLogs.getSize() - 1));
            Storage.appendLogToFile(newWater);
            Ui.printMessage(" Now you have " + waterLogs.getSize() + " water logs in the list.");
            break;

        case "workout":
            if (!input.contains("/r") || !input.contains("/s") || !input.contains("/d")) {

                throw new InvalidWorkoutException();
            }

            String workoutDetails = input.substring("add workout ".length()).trim();
            String[] workoutTokens = workoutDetails.split(" /");
            if (workoutTokens.length != 4) {

                throw new InvalidWorkoutException();
            }

            String exercise = workoutTokens[0].trim();
            String reps = workoutTokens[1].substring(2).trim(); // remove "r "
            String sets = workoutTokens[2].substring(2).trim(); // remove "s "
            String date = workoutTokens[3].substring(2).trim(); // remove "d "
            if (exercise.isEmpty() || reps.isEmpty() || sets.isEmpty() || date.isEmpty()) {

                throw new InvalidWorkoutException();
            }

            Test newWorkout = new Test(exercise, reps, sets, date);
            workoutLogs.addLog(newWorkout);
            Ui.printMessage(" Got it. I've added this workout:");
            Ui.printMessage("   " + workoutLogs.getLog(workoutLogs.getSize() - 1));
            Storage.appendLogToFile(newWorkout);
            Ui.printMessage(" Now you have " + workoutLogs.getSize() + " workout done.");
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
            Storage.appendLogToFile(newMeal);
            Ui.printMessage(" Now you have " + mealLogs.getSize() + " meals in the list.");
            break;

        default:
            Ui.printMessage("Invalid type of log");
        }
    }
}
