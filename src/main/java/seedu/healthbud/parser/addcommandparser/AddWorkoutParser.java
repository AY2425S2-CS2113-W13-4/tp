package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.AddWorkoutCommand;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddWorkoutParser {

    //@@author Ahmish15
    public static AddWorkoutCommand parse(LogList workoutLogs, String input)
            throws InvalidWorkoutException, InvalidDateFormatException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidWorkoutException();
        }

        assert input != null : "Invalid workout input!";
        if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ") || !input.contains("/w ")) {
            throw new InvalidWorkoutException();
        }
        // Remove command prefix and trim
        input = input.replaceFirst("add workout", "").trim();

        if (input.isEmpty()) {
            throw new InvalidWorkoutException();
        }

        int firstParamIndex = input.indexOf('/');
        String workoutName;
        if (firstParamIndex > 0) {
            workoutName = input.substring(0, firstParamIndex).trim();
        } else {
            workoutName = "";  // No name provided before parameters
        }
        Map<String, String> param = ParserParameters.parseParameters(input.substring(firstParamIndex));

        // Validate required parameters
        if (workoutName.isEmpty() ||
                !param.containsKey("r") || param.get("r").isEmpty() ||
                !param.containsKey("s") || param.get("s").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("w") || param.get("w").isEmpty()) {
            throw new InvalidWorkoutException();
        }

        // Validate numeric parameters
        if (!param.get("r").matches("\\d+") || !param.get("s").matches("\\d+") ||
                !param.get("w").matches("\\d+(\\.\\d+)?")) {
            throw new InvalidWorkoutException();
        }

        // Parse and format the date
        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddWorkoutCommand(workoutLogs, input, workoutName,
                param.get("r"), param.get("s"), formattedDate, param.get("w"));
    }
}
