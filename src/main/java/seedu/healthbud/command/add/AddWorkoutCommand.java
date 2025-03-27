package seedu.healthbud.command.add;

import seedu.healthbud.LogList;
import java.util.Map;
import seedu.healthbud.ParserParameters;
import seedu.healthbud.command.Command;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.log.WorkOUT;

public class AddWorkoutCommand extends Command {


    public void execute(LogList workoutLogs, String input) throws InvalidLogException {
        String[] parts = input.trim().split(" ");
        String command = parts[1];
        if (parts.length < 2) {
            throw new InvalidLogException();
        }

        Map<String, String> param = ParserParameters.parseParameters(input);

        assert input != null : "Invalid workout input!";

        if (!input.contains("/r ") || !input.contains("/s ") || !input.contains("/d ")) {
            throw new InvalidLogException();
        }

        input = input.substring("add workout".length()).trim();

        String workoutName = input.substring(0, input.indexOf("/")).trim();

        if (param.get("r").isEmpty() || param.get("s").isEmpty() || param.get("d").isEmpty()
                || workoutName.isEmpty()) {
            throw new InvalidLogException();
        }

        if (!param.get("r").matches("\\d+") || !param.get("s").matches("\\d+")) {
            throw new InvalidLogException();
        }

        WorkOUT newWorkout = new WorkOUT(workoutName, param.get("r"), param.get("s"), param.get("d"));
        workoutLogs.addLog(newWorkout);
    }

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input) throws Exception {

    }
}
