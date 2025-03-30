package seedu.healthbud.command.alllogsandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;

public class StatusCommand extends AllLogsCommand {

    private static String currentStatus = "neutral";
    private final String message;

    public StatusCommand(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                         LogList waterLogs, LogList cardioLogs, String input, String message) {
        super(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);
        this.message = message;
    }

    @Override
    public void execute(){
        Ui.printMessage(message);
    }
}
