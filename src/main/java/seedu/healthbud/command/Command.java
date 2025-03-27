package seedu.healthbud.command;

import seedu.healthbud.LogList;

public abstract class Command {

    public abstract void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                                 LogList waterLogs, LogList cardioLogs, String input) throws Exception;
}
