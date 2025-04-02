package seedu.healthbud.command.multilog;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.MultiLogCommand;

public class StatusCommand extends MultiLogCommand {

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
