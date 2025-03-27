package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidViewException;

public class ViewCommand extends Command {

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
            LogList waterLogs, LogList cardioLogs, String input) throws InvalidViewException {
        assert input != null && !input.trim().isEmpty() : "Input should not be null or empty for view command";

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidViewException();
        }

        String date = parts[1];
        Ui.printMessage("Showing logs for date: " + date);

        boolean foundAny = false;

        foundAny |= printLogsForDate(goalLogs,    "Goal",     date);
        foundAny |= printLogsForDate(pbLogs,      "PB",       date);
        foundAny |= printLogsForDate(mealLogs,    "Meal",     date);
        foundAny |= printLogsForDate(cardioLogs,  "Cardio",   date);
        foundAny |= printLogsForDate(workoutLogs, "Workout",  date);
        foundAny |= printLogsForDate(waterLogs,   "Water",    date);

        if (!foundAny) {
            Ui.printMessage("No logs found for this date.");
        }
    }

    private boolean printLogsForDate(LogList logs, String label, String date) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            if (logs.getLog(i).getDate().equals(date)) {
                Ui.printMessage(label + ": " + logs.getLog(i).toString());
                found = true;
            }
        }
        return found;
    }
}
