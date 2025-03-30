package seedu.healthbud.command.AllLogsAndInput;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;

public class ViewCommand extends AllLogsCommand {

    private final String arg;

    public ViewCommand(String input, String arg,
                       LogList goalLogs, LogList pbLogs, LogList mealLogs,
                       LogList workoutLogs, LogList waterLogs, LogList cardioLogs) {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
        this.arg = arg;
    }

    @Override
    public void execute() {
        assert input != null && !input.trim().isEmpty() : "Input should not be null or empty for view command";

        if (arg.equals("all")) {
            Ui.printMessage("Showing all logs:");

            boolean foundAny = false;
            foundAny |= printAllLogs(goalLogs, "Goal");
            foundAny |= printAllLogs(pbLogs, "PB");
            foundAny |= printAllLogs(mealLogs, "Meal");
            foundAny |= printAllLogs(cardioLogs, "Cardio");
            foundAny |= printAllLogs(workoutLogs, "Workout");
            foundAny |= printAllLogs(waterLogs, "Water");

            if (!foundAny) {
                Ui.printMessage("No logs found.");
            }
        } else {
            String date = arg;
            Ui.printMessage("Showing logs for date: " + date);

            boolean foundAny = false;
            foundAny |= printLogsForDate(goalLogs, "Goal", date);
            foundAny |= printLogsForDate(pbLogs, "PB", date);
            foundAny |= printLogsForDate(mealLogs, "Meal", date);
            foundAny |= printLogsForDate(cardioLogs, "Cardio", date);
            foundAny |= printLogsForDate(workoutLogs, "Workout", date);
            foundAny |= printLogsForDate(waterLogs, "Water", date);

            if (!foundAny) {
                Ui.printMessage("No logs found for this date.");
            }
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

    private boolean printAllLogs(LogList logs, String label) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            Ui.printMessage(label + ": " + logs.getLog(i).toString());
            found = true;
        }
        return found;
    }
}
