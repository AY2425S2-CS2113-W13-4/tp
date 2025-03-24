package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidClearException;

public class ClearCommand extends Command {

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input) {

        assert input != null && !input.trim().isEmpty() : "Input must be provided for Clear command";

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            return;
        }

        switch (parts[1]) {
        case "pb":
            pbLogs.clearLogs();
            break;

        case "meal":
            mealLogs.clearLogs();
            break;

        case "workout":
            workoutLogs.clearLogs();
            break;

        case "water":
            waterLogs.clearLogs();
            break;

        default:
            throw new InvalidClearException();
        }
    }
}
