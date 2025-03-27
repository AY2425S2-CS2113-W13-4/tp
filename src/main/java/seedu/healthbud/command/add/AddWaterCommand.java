package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.log.Water;

public abstract class AddWaterCommand extends Command {

    public void execute(LogList waterLogs, String input) throws InvalidWaterException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidWaterException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        assert input != null : "Invalid water input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/ml ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidWaterException();
        }

        input = input.substring("add water".length()).trim();

        if (param.get("ml").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()) {
            throw new InvalidWaterException();
        }

        if (!param.get("ml").matches("\\d+")) {
            throw new InvalidWaterException();
        }

        Water newWater = new Water(param.get("ml"), param.get("d"), param.get("t"));
        waterLogs.addLog(newWater);
    }
}

