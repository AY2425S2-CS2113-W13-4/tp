package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.AllLogsAndInput.ViewCommand;
import seedu.healthbud.exception.InvalidViewException;

public class ViewParser {

    public static ViewCommand parse(String input,
                                    LogList goalLogs, LogList pbLogs, LogList mealLogs,
                                    LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidViewException {

        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidViewException();
        }

        String arg = parts[1].toLowerCase();
        return new ViewCommand(input, arg, goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs);
    }
}
