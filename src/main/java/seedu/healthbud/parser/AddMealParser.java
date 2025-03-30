package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.OneLogAndInput.AddMealCommand;
import seedu.healthbud.exception.InvalidMealException;

import java.util.Map;

public class AddMealParser {

    public static AddMealCommand parse(LogList mealLogs, String input) throws InvalidMealException {
        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidMealException();
        }

        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidMealException();
        }

        input = input.substring("add meal".length()).trim();
        String name = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (param.get("cal").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty() || name.isEmpty()) {
            throw new InvalidMealException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new InvalidMealException();
        }

        return new AddMealCommand(mealLogs, input, name, param.get("cal"), param.get("d"), param.get("t"));
    }
}
