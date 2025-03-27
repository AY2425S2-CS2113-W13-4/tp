package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidStatusException;

public class StatusCommand extends Command{

    private static String currentStatus = "neutral";

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input)
            throws InvalidStatusException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidStatusException();
        }
        String command = parts[1];
        switch (command) {

        case "change":
            if (parts.length < 3 || (!parts[2].equals("cutting") && !parts[2].equals("bulking"))) {
                throw new InvalidStatusException();
            }
            currentStatus = parts[2];
            Ui.printMessage("Status updated to: " + currentStatus);
            break;
        case "report":
            if (parts.length < 3) {
                throw new InvalidStatusException();
            }
            String date = parts[2];

            int caloriesEaten = mealLogs.getCaloriesSum(date);
            int caloriesBurned = cardioLogs.getCardioSum(date);
            int netCalories = caloriesEaten - caloriesBurned;

            Ui.printMessage("Current Status: " + currentStatus);

            if (currentStatus.equals("bulking") && netCalories > 0) {
                Ui.printMessage("You are on track for bulking! Net calories: " + netCalories);
            } else if (currentStatus.equals("cutting") && netCalories < 0) {
                Ui.printMessage("You are on track for cutting! Net calories: " + netCalories);
            } else {
                Ui.printMessage("Your intake does not align with your goal. Net calories: " + netCalories);
            }
            break;
        default:
            throw new InvalidStatusException();
        }
    }
}
