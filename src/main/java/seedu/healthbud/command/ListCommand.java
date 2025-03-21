package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidListException;

public class ListCommand extends Command {

    @Override
    public void execute(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws InvalidListException {

        String[] parts = input.split(" ");

        if (parts.length < 2) {
            throw new InvalidListException();
        }

        switch (parts[1]) {
        case "meal":
            mealLogs.listLogs();
            break;

        case "workout":
            workoutLogs.listLogs();
            break;

        case "water":
            waterLogs.listLogs();
            break;

        case "pb":
            pbLogs.listLogs();
            break;

        default:
            throw new InvalidListException();
        }
    }
}
