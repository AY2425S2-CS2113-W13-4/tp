package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.OneLogAndInput.AddWorkoutCommand;
import seedu.healthbud.exception.InvalidWorkoutException;

import java.util.Map;

public class AddWorkoutParser {

    public static AddWorkoutCommand parse(LogList workoutLogs, String input) throws InvalidWorkoutException {
        String[] parts = input.trim().split(" ");
        if (parts.length < 2) {
            throw new InvalidWorkoutException();
        }

        assert input != null : "Invalid workout input!";
        if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ")) {
            throw new InvalidWorkoutException();
        }

        input = input.substring("add workout".length()).trim();

        String workoutName = input.substring(0, input.indexOf("/")).trim();
        Map<String, String> param = ParserParameters.parseParameters(input);

        if (workoutName.isEmpty() || param.get("r").isEmpty() || param.get("s").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidWorkoutException();
        }

        if (!param.get("r").matches("\\d+") || !param.get("s").matches("\\d+")) {
            throw new InvalidWorkoutException();
        }

        return new AddWorkoutCommand(workoutLogs, input, workoutName, param.get("r"), param.get("s"), param.get("d"));
    }
}
