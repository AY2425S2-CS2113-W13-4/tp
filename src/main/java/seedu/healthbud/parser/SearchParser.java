package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.SearchCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidSearchException;

public class SearchParser {

    public static SearchCommand parse(String input,
                                      LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList pbLogs, LogList cardioLogs, LogList goalLogs)
            throws InvalidSearchException, InvalidDateFormatException {

        String[] parts = input.trim().split("\\s+");
        if (parts.length < 4) {
            throw new InvalidSearchException(
                    "Invalid search command format. Try search <logType> /d <date> OR search <logType> /k <keyword>");
        }

        // parts[0] should be "search"
        String logType = parts[1].toLowerCase();
        String flag = parts[2].toLowerCase();
        String parameter = parts[3];

        String date = null;
        String keyword = null;
        if (flag.equals("/d")) {
            date = DateParser.formatDate(parameter);
        } else if (flag.equals("/k")) {
            keyword = parameter;
        } else {
            throw new InvalidSearchException("Invalid parameter flag. Use /d for date or /k for keyword.");
        }

        LogList targetLogList;
        switch (logType) {
        case "meal":
            targetLogList = mealLogs;
            break;
        case "workout":
            targetLogList = workoutLogs;
            break;
        case "water":
            targetLogList = waterLogs;
            break;
        case "pb":
            targetLogList = pbLogs;
            break;
        case "cardio":
            targetLogList = cardioLogs;
            break;
        case "goal":
            targetLogList = goalLogs;
            break;
        default:
            throw new InvalidSearchException("Invalid log type. Valid types: meal, workout, water, pb, cardio.");
        }

        return new SearchCommand(input, targetLogList, date, keyword);
    }
}
