package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.DeleteCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDeleteException;

public class DeleteParser {

    public static DeleteCommand parse(String input, LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                                      LogList pbLogs, LogList cardioLogs)
            throws InvalidDeleteException, HealthBudException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 3) {
            throw new InvalidDeleteException();
        }

        String logType = parts[1].toLowerCase();
        int index;

        try {
            index = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new HealthBudException("Insert a valid task number");
        }

        switch (logType) {
        case "meal":
            return new DeleteCommand(mealLogs, input, index);
        case "workout":
            return new DeleteCommand(workoutLogs, input, index);
        case "water":
            return new DeleteCommand(waterLogs, input, index);
        case "pb":
            return new DeleteCommand(pbLogs, input, index);
        case "cardio":
            return new DeleteCommand(cardioLogs, input, index);

        default:
            throw new InvalidDeleteException();
        }
    }
}
