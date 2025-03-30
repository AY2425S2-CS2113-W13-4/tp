package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.AddWaterCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddWaterParser {

    public static AddWaterCommand parse(LogList waterLogs, String input)
            throws InvalidWaterException, InvalidDateFormatException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidWaterException();
        }

        assert input != null : "Invalid water input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidWaterException();
        }

        input = input.replaceFirst("add water", "").trim();
        if (input.isEmpty()) {
            throw new InvalidWaterException();
        }

        int firstParamIndex = input.indexOf('/');
        String waterInput;
        if (firstParamIndex > 0) {
            waterInput = input.substring(0, firstParamIndex).trim();
        } else {
            waterInput = "";  // No name provided before parameters
        }
        Map<String, String> param = ParserParameters.parseParameters(input.substring(firstParamIndex));

        if (!param.containsKey("ml") || param.get("ml").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty() ||
                !param.containsKey("t") || param.get("t").isEmpty()) {
            throw new InvalidWaterException();
        }

        if (!param.get("ml").matches("\\d+")) {
            throw new InvalidWaterException();
        }

        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddWaterCommand(waterLogs, waterInput,
                param.get("ml"), formattedDate, param.get("t"));
    }
}
