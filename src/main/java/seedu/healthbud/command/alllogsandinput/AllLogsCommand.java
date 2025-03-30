package seedu.healthbud.command.alllogsandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.command.commandinterface.Command;

// FOR COMMANDS THAT NEEDS MORE THAN 1 LOG LIST AND INPUT

public abstract class AllLogsCommand implements Command {
    protected LogList goalLogs;
    protected LogList pbLogs;
    protected LogList mealLogs;
    protected LogList workoutLogs;
    protected LogList waterLogs;
    protected LogList cardioLogs;
    protected String input;

    public AllLogsCommand(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                          LogList waterLogs, LogList cardioLogs, String input) {
        this.goalLogs = goalLogs;
        this.pbLogs = pbLogs;
        this.mealLogs = mealLogs;
        this.workoutLogs = workoutLogs;
        this.waterLogs = waterLogs;
        this.cardioLogs = cardioLogs;
        this.input = input;
    }
}
