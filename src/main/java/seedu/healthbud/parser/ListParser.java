package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.ListCommand;
import seedu.healthbud.exception.InvalidListException;

public class ListParser {

    public static ListCommand parse(String input, LogList mealLogs, LogList workoutLogs,
                                    LogList waterLogs, LogList pbLogs, LogList cardioLogs)
            throws InvalidListException {

        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidListException();
        }

        String logType = parts[1].toLowerCase();

        switch (logType) {
        case "meal":
            return new ListCommand(input, mealLogs);
        case "workout":
            return new ListCommand(input, workoutLogs);
        case "water":
            return new ListCommand(input, waterLogs);
        case "pb":
            return new ListCommand(input, pbLogs);
        case "cardio":
            return new ListCommand(input, cardioLogs);
        default:
            throw new InvalidListException();
        }
    }
}
