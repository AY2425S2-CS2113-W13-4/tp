package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.FindCommand;
import seedu.healthbud.exception.InvalidFindException;

public class FindParser {

    public static FindCommand parse(String input, LogList mealLogs, LogList workoutLogs,
                                    LogList waterLogs, LogList pbLogs, LogList cardioLogs) throws InvalidFindException {
        String[] parts = input.trim().split(" ");

        if (parts.length < 3) {
            throw new InvalidFindException();
        }

        String logType = parts[1].toLowerCase();
        String keyword = parts[2];

        switch (logType) {
        case "meal":
            return new FindCommand(input, mealLogs, keyword);
        case "workout":
            return new FindCommand(input, workoutLogs, keyword);
        case "water":
            return new FindCommand(input, waterLogs, keyword);
        case "pb":
            return new FindCommand(input, pbLogs, keyword);
        case "cardio":
            return new FindCommand(input, cardioLogs, keyword);
        default:
            throw new InvalidFindException();
        }
    }
}
