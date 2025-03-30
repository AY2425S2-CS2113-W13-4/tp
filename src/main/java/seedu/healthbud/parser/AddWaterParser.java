package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.OneLogAndInput.AddWaterCommand;
import seedu.healthbud.exception.InvalidWaterException;

import java.util.Map;

public class AddWaterParser {

    public static AddWaterCommand parse(LogList waterLogs, String input) throws InvalidWaterException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidWaterException();
        }

        assert input != null : "Invalid water input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidWaterException();
        }

        input = input.substring("add water".length()).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (param.get("ml").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()) {
            throw new InvalidWaterException();
        }

        if (!param.get("ml").matches("\\d+")) {
            throw new InvalidWaterException();
        }

        return new AddWaterCommand(waterLogs, input, param.get("ml"), param.get("d"), param.get("t"));
    }
}
