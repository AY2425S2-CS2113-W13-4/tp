package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddMealCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.TimeParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AddMealParser is responsible for parsing the input command for adding a meal log.
 * It extracts the meal name, calorie count, date, and time parameters from the input string
 * and returns an AddMealCommand with the parsed details.
 */
public class AddMealParser {

    /**
     * Parses the given input command for adding a meal log and returns an AddMealCommand.
     *
     * @param mealLogs the LogList for meal logs; must not be null.
     * @param input the input command string; must not be null.
     * @return an AddMealCommand with the parsed meal log details.
     * @throws InvalidMealException if the input format is invalid or required parameters are missing.
     * @throws InvalidDateFormatException if the provided date cannot be parsed.
     */
    //@@author Ahmish15
    public static AddMealCommand parse(LogList mealLogs, String input)
            throws InvalidMealException, InvalidDateException, InvalidDateFormatException, HealthBudException {

        assert input != null : "Input should not be null";
        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidMealException();
        }

        input = input.substring("add meal".length()).trim();

        String name = input.substring(0, input.indexOf("/")).trim().replaceAll("\\s+", " ");;

        Map<String, String> param = ParserParameters.parseParameters(input.substring(name.length()));
        Set<String> allowedKeys = new HashSet<>(Arrays.asList("cal", "d", "t"));
        if (!param.keySet().equals(allowedKeys)) {
            throw new InvalidMealException();
        }

        if (name.isEmpty() || !param.containsKey("cal") || param.get("cal").isEmpty() || !param.containsKey("d")
                || param.get("d").isEmpty() || !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidMealException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new HealthBudException("Calorie count must be a positive integer.");
        }

        int cal = Integer.parseInt(param.get("cal"));
        if (cal < 0 || cal > 10000) {
            throw new HealthBudException("Calorie count must be between 0 and 10000.");
        }

        String trimmedCal = param.get("cal").replaceFirst("^0+(?=\\d)", "");

        String formattedDate = DateParser.formatDate(param.get("d"));
        String formattedTime = TimeParser.formatTime(param.get("t"));

        return new AddMealCommand(mealLogs, name, trimmedCal, formattedDate, formattedTime);
    }
}
