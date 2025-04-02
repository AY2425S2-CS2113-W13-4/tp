package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;

public class ListCommand extends SingleLogCommand {
    public ListCommand(String input, LogList logList) {
        super(logList, input);
    }

    @Override
    public void execute() {
        logList.listLogs();
    }
}
