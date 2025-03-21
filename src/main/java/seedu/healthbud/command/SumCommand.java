package seedu.healthbud.command;


import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidSumException;

public class SumCommand extends Command {

    @Override
    public void execute(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws InvalidSumException {

        String[] parts = input.trim().split(" ");
        if (parts.length < 3) {
            throw new InvalidSumException();
        }

        switch (parts[1]) {
        case "cal":
            mealLogs.getCaloriesSum(parts[2]);
            break;

        case "vol":
            Ui.printMessage("Feature not available yet");
            break;

        default:
            throw new InvalidSumException();
        }
    }
}
