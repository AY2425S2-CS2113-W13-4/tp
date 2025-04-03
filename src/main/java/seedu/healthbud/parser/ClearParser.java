package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.ClearCommand;
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
            return new ClearCommand(pbLogs);
        case "meal":
            return new ClearCommand(mealLogs);
        case "workout":
            return new ClearCommand( workoutLogs);
        case "water":
            return new ClearCommand(waterLogs);
        case "cardio":
            return new ClearCommand(cardioLogs);
        default:
            throw new InvalidClearException();
        }
    }
}
