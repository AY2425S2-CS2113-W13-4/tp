package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddPersonalBestCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddPersonalBestParser {

    public static AddPersonalBestCommand parse(LogList pbLogs, String input)
            throws InvalidPersonalBestException, InvalidDateFormatException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidPersonalBestException();
        }

        assert input != null : "Invalid personal best input!";
        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPersonalBestException();
        }

        input = input.replaceFirst("add pb", "").trim();

        if (input.isEmpty()) {
            throw new InvalidPersonalBestException();
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
                !param.containsKey("w") || param.get("w").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty()) {
            throw new InvalidPersonalBestException();
        }

        if (!param.get("w").matches("\\d+")) {
            throw new InvalidPersonalBestException();
        }
        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddPersonalBestCommand(pbLogs, input, name,
                param.get("w"), formattedDate);
    }
}

