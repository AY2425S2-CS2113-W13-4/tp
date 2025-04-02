package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.multilog.StatusCommand;
import seedu.healthbud.exception.InvalidStatusException;

public class StatusParser {

    private static String currentStatus = "neutral";

    public static StatusCommand parse(String input, LogList goalLogs, LogList pbLogs, LogList mealLogs,
                                      LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidStatusException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 3) {
            throw new InvalidStatusException();
        }

        String action = parts[1].toLowerCase();
        String arg = parts[2].toLowerCase();

        String message;

        switch (action) {
        case "change":
            if (!arg.equals("cutting") && !arg.equals("bulking")) {
                throw new InvalidStatusException();
            }
            currentStatus = arg;
            message = "Status updated to: " + currentStatus;
            break;

        case "report":
            int caloriesEaten = mealLogs.getCaloriesSum(arg);
            int caloriesBurned = cardioLogs.getCardioSum(arg);
            int netCalories = caloriesEaten - caloriesBurned;

            StringBuilder sb = new StringBuilder();
            sb.append("Current Status: ").append(currentStatus).append("\n");

            if (currentStatus.equals("bulking") && netCalories > 0) {
                sb.append("You are on track for bulking! Net calories: ").append(netCalories);
            } else if (currentStatus.equals("cutting") && netCalories < 0) {
                sb.append("You are on track for cutting! Net calories: ").append(netCalories);
            } else {
                sb.append("Your intake does not align with your goal. Net calories: ").append(netCalories);
            }

            message = sb.toString();
            break;

        default:
            throw new InvalidStatusException();
        }

        return new StatusCommand(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input, message);
    }
}
