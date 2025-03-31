package seedu.healthbud.command.alllogsandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidDateFormatException;

public class ViewCommand extends AllLogsCommand {

    private final String logType;
    private final String date;

    public ViewCommand(String input, String logType, String date,
                       LogList goalLogs, LogList pbLogs, LogList mealLogs,
                       LogList workoutLogs, LogList waterLogs, LogList cardioLogs) {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
        this.logType = logType;
        this.date = date;
    }

    @Override
    public void execute() throws InvalidDateFormatException {
        assert input != null && !input.trim().isEmpty() : "Input should not be null or empty for view command";

        // Case 1: View all logs
        if ("all".equals(logType)) {
            handleViewAll();
            return;
        }

        // Case 2: View by date only
        if (logType == null && date != null) {
            handleViewByDate();
            return;
        }

        // Case 3: View by log type (with optional date)
        handleLogTypeView();
    }

    private void handleViewAll() {
        Ui.printMessage("Showing all logs:");
        boolean foundAny = printAllLogs();
        if (!foundAny) {
            Ui.printMessage("No logs found.");
        }
    }

    private void handleViewByDate() {
        Ui.printMessage("Showing logs for date: " + date);
        boolean foundAny = printLogsForDate();
        if (!foundAny) {
            Ui.printMessage("No logs found for this date.");
        }
    }

    private void handleLogTypeView() {
        LogList targetLogs = getTargetLogList();
        String label = getLabelForLogType();

        if (targetLogs == null) {
            Ui.printMessage("Invalid log type. Available types: goal, pb, meal, workout, water, cardio");
            return;
        }

        if (date == null) {
            // View all logs of this type
            Ui.printMessage("Showing all " + label + " logs:");
            boolean found = printAllLogs(targetLogs, label);
            if (!found) {
                Ui.printMessage("No " + label + " logs found.");
            }
        } else {
            // View logs of this type for specific date
            Ui.printMessage("Showing " + label + " logs for date: " + date);
            boolean found = printLogsForDate(targetLogs, label, date);
            if (!found) {
                Ui.printMessage("No " + label + " logs found for this date.");
            }
        }
    }

    private boolean printAllLogs() {
        boolean foundAny = false;
        foundAny |= printAllLogs(goalLogs, "Goal");
        foundAny |= printAllLogs(pbLogs, "PB");
        foundAny |= printAllLogs(mealLogs, "Meal");
        foundAny |= printAllLogs(cardioLogs, "Cardio");
        foundAny |= printAllLogs(workoutLogs, "Workout");
        foundAny |= printAllLogs(waterLogs, "Water");
        return foundAny;
    }

    private boolean printAllLogs(LogList logs, String label) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            Ui.printMessage(label + ": " + logs.getLog(i).toString());
            found = true;
        }
        return found;
    }

    private boolean printLogsForDate() {
        boolean foundAny = false;
        foundAny |= printLogsForDate(goalLogs, "Goal", date);
        foundAny |= printLogsForDate(pbLogs, "PB", date);
        foundAny |= printLogsForDate(mealLogs, "Meal", date);
        foundAny |= printLogsForDate(cardioLogs, "Cardio", date);
        foundAny |= printLogsForDate(workoutLogs, "Workout", date);
        foundAny |= printLogsForDate(waterLogs, "Water", date);
        return foundAny;
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

    private LogList getTargetLogList() {
        switch (logType) {
        case "goal": return goalLogs;
        case "pb": return pbLogs;
        case "meal": return mealLogs;
        case "workout": return workoutLogs;
        case "water": return waterLogs;
        case "cardio": return cardioLogs;
        default: return null;
        }
    }

    private String getLabelForLogType() {
        switch (logType) {
        case "goal": return "Goal";
        case "pb": return "PB";
        case "meal": return "Meal";
        case "workout": return "Workout";
        case "water": return "Water";
        case "cardio": return "Cardio";
        default: return "Unknown";
        }
    }
}
