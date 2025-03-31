package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.alllogsandinput.ViewCommand;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidViewException;
import seedu.healthbud.exception.InvalidDateFormatException;
import java.util.Map;

public class ViewParser {

    public static ViewCommand parse(String input,
                                    LogList goalLogs, LogList pbLogs, LogList mealLogs,
                                    LogList workoutLogs, LogList waterLogs, LogList cardioLogs)
            throws InvalidViewException, InvalidDateFormatException {

        // Basic input validation
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidViewException();
        }

        String[] parts = input.split(" ", 3);
        if (parts.length < 2 || !parts[0].equals("view")) {
            throw new InvalidViewException();
        }

        // Check for required parameters
        if (!input.contains("/m") && !input.contains("/d")) {
            throw new InvalidViewException();
        }

        // Extract parameters
        String paramsString = input.replaceFirst("view", "").trim();
        if (paramsString.isEmpty()) {
            throw new InvalidViewException();
        }

        int firstParamIndex = paramsString.indexOf('/');
        Map<String, String> params = ParserParameters.parseParameters(paramsString.substring(firstParamIndex));

        String logType = params.get("m");
        String dateParam = params.get("d");
        String formattedDate = null;

        // Process date if present
        if (dateParam != null) {
            try {
                formattedDate = DateParser.formatDate(dateParam);
            } catch (InvalidDateFormatException e) {
                throw new InvalidDateException();
            }
        }

        // Process log type if present
        if (logType != null) {
            if (!isValidLogType(logType)) {
                throw new InvalidViewException();
            }
            // Special case: /m all shouldn't have date
            if (logType.equals("all") && dateParam != null) {
                throw new InvalidViewException();
            }
        }

        return new ViewCommand(
                input,
                logType,
                formattedDate,
                goalLogs, pbLogs, mealLogs,
                workoutLogs, waterLogs, cardioLogs
        );
    }

    private static boolean isValidLogType(String type) {
        return type != null &&
                type.matches("all|goal|pb|meal|workout|water|cardio");
    }
}
