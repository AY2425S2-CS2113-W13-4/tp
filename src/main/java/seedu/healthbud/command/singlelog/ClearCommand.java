package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;

public class ClearCommand extends SingleLogCommand {


    public ClearCommand(String input, LogList logList) {
        super(logList, input);
    }

    @Override
    public void execute() {
        assert input != null && !input.trim().isEmpty() : "Input must be provided for Clear command";
        logList.clearLogs();
    }
}
