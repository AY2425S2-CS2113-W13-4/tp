package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddWorkoutCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AddWorkoutParser is responsible for parsing the input command for adding a workout.
 * It extracts the workout details from the input string and returns an AddWorkoutCommand.
 */
public class AddWorkoutParser {

    /**
     * Parses the input command for adding a workout and returns an AddWorkoutCommand.
     *
     * @param workoutLogs the LogList for workout logs; must not be null.
     * @param input the input command string; must not be null.
     * @return an AddWorkoutCommand containing the parsed workout details.
     * @throws InvalidWorkoutException if the input format is invalid or required parameters are missing.
     * @throws InvalidDateFormatException if the date provided cannot be parsed.
     */
    public static AddWorkoutCommand parse(LogList workoutLogs, String input)
            throws InvalidWorkoutException, InvalidDateException, InvalidDateFormatException, HealthBudException {

        assert input != null : "Input should not be null";

        if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ") || !input.contains("/w ")) {
            throw new InvalidWorkoutException();
        }

        input = input.substring("add workout".length()).trim();

        String name = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input.substring(name.length()));
        Set<String> allowedKeys = new HashSet<>(Arrays.asList("r", "d", "s", "w"));
        if (!param.keySet().equals(allowedKeys)) {
            throw new InvalidWorkoutException();
        }

        if (name.isEmpty() ||
                !param.containsKey("r") || param.get("r").isEmpty() ||
                !param.containsKey("s") || param.get("s").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("w") || param.get("w").isEmpty()) {
            throw new InvalidWorkoutException();
        }

        if (!param.get("r").matches("^-?\\d+$") || !param.get("s").matches("^-?\\d+$") ||
                !param.get("w").matches("^-?\\d+(\\.\\d+)?$")) {
            throw new InvalidWorkoutException();
        }

        int rep = Integer.parseInt(param.get("r"));
        int set = Integer.parseInt(param.get("s"));
        Double weight = Double.parseDouble(param.get("w"));

        if (rep <= 0 || rep > 100) {
            throw new HealthBudException("Reps should be a positive integer between 1 and 100.");
        }
        if (set <= 0 || set > 100) {
            throw new HealthBudException("Sets should be a positive integer between 1 and 100.");
        }
        if (weight <= 0 || weight > 1000) {
            throw new HealthBudException("Weight should be greater than 0 and less than 1000kg.");
        }

        String trimmedRep = param.get("r").replaceFirst("^0+(?![.$])", "");
        String trimmedSet = param.get("s").replaceFirst("^0+(?![.$])", "");
        String trimmedWeight = param.get("w").replaceFirst("^0+(?![.$])", "");

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddWorkoutCommand(workoutLogs, name, trimmedRep, trimmedSet,
                formattedDate, trimmedWeight);
    }
}
