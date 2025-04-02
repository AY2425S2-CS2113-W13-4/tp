package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddMealCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;


public class AddMealParser {

    //@@author Ahmish15
    public static AddMealCommand parse(LogList mealLogs, String input)
            throws InvalidMealException, InvalidDateFormatException {

        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidMealException();
        }

        assert input != null : "Invalid meal input!";
        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidMealException();
        }

        input = input.replaceFirst("add meal", "").trim();

        if (input.isEmpty()) {
            throw new InvalidMealException();
        }

        int firstParamIndex = input.indexOf('/');
        String name;
        if (firstParamIndex > 0) {
            name = input.substring(0, firstParamIndex).trim();
        } else {
            name = "";  // No name provided before parameters
        }
        Map<String, String> param = ParserParameters.parseParameters(input.substring(firstParamIndex));


        if (name.isEmpty() ||
                !param.containsKey("cal") || param.get("cal").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidMealException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new InvalidMealException();
        }

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddMealCommand(mealLogs, input, name, param.get("cal"), formattedDate, param.get("t"));
    }
}
