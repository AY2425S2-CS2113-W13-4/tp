package seedu.healthbud.command;

import seedu.healthbud.LogList;

public abstract class Command {
    public abstract void execute(LogList pbLogs, LogList mealLogs, LogList workoutLogs, LogList waterLogs, String input)
            throws Exception;
}
