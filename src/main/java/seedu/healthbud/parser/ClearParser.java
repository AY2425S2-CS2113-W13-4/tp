package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.ClearCommand;
import seedu.healthbud.exception.InvalidClearException;

public class ClearParser {

    public static ClearCommand parse(String input, LogList pbLogs, LogList mealLogs,
                                     LogList workoutLogs, LogList waterLogs, LogList cardioLogs) throws
                                    InvalidClearException {

        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidClearException();
        }

        String logType = parts[1].toLowerCase();

        switch (logType) {
        case "pb":
            return new ClearCommand(input, pbLogs);
        case "meal":
            return new ClearCommand(input, mealLogs);
        case "workout":
            return new ClearCommand(input, workoutLogs);
        case "water":
            return new ClearCommand(input, waterLogs);
        case "cardio":
            return new ClearCommand(input, cardioLogs);
        default:
            throw new InvalidClearException();
        }
    }
}
