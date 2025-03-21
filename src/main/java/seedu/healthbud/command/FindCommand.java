package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidFindException;

public class FindCommand extends Command {


    @Override
    public void execute(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws InvalidFindException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 3) {
            throw new InvalidFindException();
        }

        switch (parts[1]) {
        case "meal":
            mealLogs.findLog(parts[2]);
            break;

        case "workout":
            workoutLogs.findLog(parts[2]);
            break;

        case "water":
            waterLogs.findLog(parts[2]);
            break;
        default:
            throw new InvalidFindException();
        }
    }
}
