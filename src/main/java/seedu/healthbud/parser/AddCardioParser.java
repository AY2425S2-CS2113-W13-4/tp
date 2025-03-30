package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.OneLogAndInput.AddCardioCommand;
import seedu.healthbud.exception.InvalidCardioException;

import java.util.Map;

public class AddCardioParser {

    public static AddCardioCommand parse(LogList cardioLogs, String input) throws InvalidCardioException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidCardioException();
        }

        if (!input.contains("/s ") || !input.contains("/i ") || !input.contains("/t ") || !input.contains("/d ")) {
            throw new InvalidCardioException();
        }

        input = input.substring("add cardio".length()).trim();
        String cardioName = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (cardioName.isEmpty() || param.get("s").isEmpty() || param.get("i").isEmpty()
                || param.get("t").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidCardioException();
        }

        if (!param.get("s").matches("\\d+") || !param.get("i").matches("\\d+") ||
                !param.get("t").matches("\\d+")) {
            throw new InvalidCardioException();
        }

        return new AddCardioCommand(cardioLogs, input, cardioName, param.get("s"), param.get("i"), param.get("t"),
                param.get("d"));
    }
}
