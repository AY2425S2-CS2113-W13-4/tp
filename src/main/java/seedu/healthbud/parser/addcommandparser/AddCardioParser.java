package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddCardioCommand;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.parser.DateParser;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddCardioParser {

    public static AddCardioCommand parse(LogList cardioLogs, String input)
            throws InvalidCardioException, InvalidDateFormatException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidCardioException();
        }

        assert input != null : "Invalid cardio input!";
        if (!input.contains("/s ") || !input.contains("/i ") || !input.contains("/t ") || !input.contains("/d ")) {
            throw new InvalidCardioException();
        }

        // Remove command prefix and trim
        input = input.replaceFirst("add cardio", "").trim();

        if (input.isEmpty()) {
            throw new InvalidCardioException();
        }

        int firstParamIndex = input.indexOf('/');
        String cardioName;
        if (firstParamIndex > 0) {
            cardioName = input.substring(0, firstParamIndex).trim();
        } else {
            cardioName = "";  // No name provided before parameters
        }

        Map<String, String> param = ParserParameters.parseParameters(input.substring(firstParamIndex));

        // Validate required parameters
        if (cardioName.isEmpty() ||
                !param.containsKey("s") || param.get("s").isEmpty() ||
                !param.containsKey("i") || param.get("i").isEmpty() ||
                !param.containsKey("t") || param.get("t").isEmpty() ||
                !param.containsKey("d") || param.get("d").isEmpty()) {
            throw new InvalidCardioException();
        }

        if (!param.get("s").matches("\\d+(\\.\\d+)?") ||
                !param.get("i").matches("\\d+(\\.\\d+)?") ||
                !param.get("t").matches("\\d+(\\.\\d+)?")) {
            throw new InvalidCardioException();
        }

        // Parse and format the date
        String formattedDate = DateParser.formatDate(param.get("d"));

        return new AddCardioCommand(cardioLogs, input, cardioName,
                param.get("s"), param.get("i"), param.get("t"),
                formattedDate);
    }
}

