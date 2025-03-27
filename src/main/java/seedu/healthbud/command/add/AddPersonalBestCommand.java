package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.log.PB;

public class AddPersonalBestCommand extends Command {

    public void execute(LogList pbLogs, String input) throws InvalidPBException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidPBException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!input.contains("/w ") || !input.contains("/d ")) {
            throw new InvalidPBException();
        }

        input = input.substring("add pb".length()).trim();

        String pbName = input.substring(0, input.indexOf("/")).trim();

        if (pbName.isEmpty() || param.get("w").isEmpty() || param.get("d").isEmpty()) {
            throw new InvalidPBException();
        }

        if (!param.get("w").matches("\\d+")) {
            throw new InvalidPBException();
        }

        PB newPB = new PB(pbName, param.get("w"), param.get("d"));
        pbLogs.addLog(newPB);
    }

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input) throws Exception {

    }
}
