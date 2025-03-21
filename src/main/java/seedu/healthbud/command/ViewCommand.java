package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidViewException;

public class ViewCommand extends Command {

    @Override
    public void execute(
            LogList pbLogs, LogList mealLogs, LogList workoutLogs,
            LogList waterLogs, String input
    ) throws InvalidViewException {
        assert input != null && !input.trim().isEmpty() : "Input should not be null or empty for view command";

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidViewException();
        }

        String date = parts[1];
        Ui.printMessage("Showing logs for date: " + date);
        boolean foundAny = false;

        for (int i = 0; i < mealLogs.getSize(); i++) {
            if (mealLogs.getLog(i).getDate().equals(date)) {
                Ui.printMessage("Meal: " + mealLogs.getLog(i).toString());
                foundAny = true;
            }
        }

        for (int i = 0; i < workoutLogs.getSize(); i++) {
            if (workoutLogs.getLog(i).getDate().equals(date)) {
                Ui.printMessage("Workout: " + workoutLogs.getLog(i).toString());
                foundAny = true;
            }
        }

        for (int i = 0; i < waterLogs.getSize(); i++) {
            if (waterLogs.getLog(i).getDate().equals(date)) {
                Ui.printMessage("Water: " + waterLogs.getLog(i).toString());
                foundAny = true;
            }
        }

        if (!foundAny) {
            Ui.printMessage("No logs found for this date.");
        }
    }
}
