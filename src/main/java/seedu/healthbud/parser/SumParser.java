package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.SumCommand;
import seedu.healthbud.exception.InvalidSumException;

public class SumParser {

    public static SumCommand parse(String input, LogList mealLogs, LogList waterLogs, LogList cardioLogs) throws
            InvalidSumException {
        String[] parts = input.trim().split(" ");

        if (parts.length < 4 || !parts[2].equals("/d")) {
            throw new InvalidSumException();
        }

        String type = parts[1].toLowerCase();
        String date = parts[3];

        switch (type) {
        case "cal":
            return new SumCommand(input, mealLogs, type, date);
        case "vol":
            return new SumCommand(input, waterLogs, type, date);
        case "cardio":
            return new SumCommand(input, cardioLogs, type, date);
        default:
            throw new InvalidSumException();
        }
    }
}
