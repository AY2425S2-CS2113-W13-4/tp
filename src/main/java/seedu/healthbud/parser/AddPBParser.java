package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.OneLogAndInput.AddPBCommand;
import seedu.healthbud.exception.InvalidPBException;

import java.util.Map;

public class AddPBParser {

    public static AddPBCommand parse(LogList pbLogs, String input) throws InvalidPBException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidPBException();
        }

        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPBException();
        }

        input = input.substring("add pb".length()).trim();
        String name = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (name.isEmpty() || param.get("w").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidPBException();
        }

        if (!param.get("w").matches("\\d+")) {
            throw new InvalidPBException();
        }

        return new AddPBCommand(pbLogs, input, name, param.get("w"), param.get("d"));
    }
}
