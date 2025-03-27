package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.log.Cardio;

public class AddCardioCommand extends Command {

    public void execute(LogList cardioLogs, String input) throws InvalidLogException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidLogException();
        }

        assert input != null : "Invalid cardio input!";
        assert !input.trim().isEmpty() : "Input should not be empty!";

        if (!input.contains("/s ") || !input.contains("/i ") || !input.contains("/t ") || !input.contains("/d ")) {
            throw new InvalidLogException();
        }

        input = input.substring("add cardio".length()).trim();

        String cardioName = input.substring(0, input.indexOf("/")).trim();

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (cardioName.isEmpty() || param.get("s").isEmpty() || param.get("i").isEmpty()
                || param.get("t").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidLogException();
        }

        if (!param.get("s").matches("\\d+") || !param.get("i").matches("\\d+") ||
                !param.get("t").matches("\\d+")) {
            throw new InvalidLogException();
        }

        Cardio newCardio = new Cardio(cardioName, param.get("s"), param.get("i"), param.get("t"),
                param.get("d"));

        cardioLogs.addLog(newCardio);
    }

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                        LogList cardioLogs, String input) throws Exception {

    }
}
