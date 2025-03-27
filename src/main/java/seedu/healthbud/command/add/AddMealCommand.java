package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.log.Meal;

public class AddMealCommand extends Command {

    public void execute(LogList mealLogs, String input) throws InvalidLogException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidLogException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        if (!input.contains("/cal ") || !input.contains("/d ") || !input.contains("/t ")) {
            throw new InvalidLogException();
        }

        input = input.substring("add meal".length()).trim();

        String mealName = input.substring(0, input.indexOf("/")).trim();

        if (param.get("cal").isEmpty() || param.get("d").isEmpty() || param.get("t").isEmpty()
                || mealName.isEmpty()) {
            throw new InvalidLogException();
        }

        if (!param.get("cal").matches("\\d+")) {
            throw new InvalidLogException();
        }

        Meal newMeal = new Meal(mealName, param.get("cal"), param.get("d"), param.get("t"));
        mealLogs.addLog(newMeal);
    }

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input) throws Exception {

    }
}
