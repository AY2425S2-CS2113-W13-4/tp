package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.AddPBCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddPBParser {

    public static AddPBCommand parse(LogList pbLogs, String input)
            throws InvalidPBException, InvalidDateFormatException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidPBException();
        }

        assert input != null : "Invalid personal best input!";
        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPBException();
        }

        input = input.replaceFirst("add pb", "").trim();

        if (input.isEmpty()) {
            throw new InvalidPBException();
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
            throw new InvalidPBException();
        }

        if (!param.get("w").matches("\\d+")) {
            throw new InvalidPBException();
        }
        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddPBCommand(pbLogs, input, name,
                param.get("w"), formattedDate);
    }
}

