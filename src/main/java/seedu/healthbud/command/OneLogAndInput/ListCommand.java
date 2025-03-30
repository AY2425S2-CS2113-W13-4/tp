package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;

public class ListCommand extends OneLogCommand {
    public ListCommand(String input, LogList logList) {
        super(logList, input);
    }

    @Override
    public void execute() {
        logList.listLogs();
    }
}
