package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;

public class ClearCommand extends OneLogCommand {


    public ClearCommand(String input, LogList logList) {
        super(logList, input);
    }

    @Override
    public void execute() {
        assert input != null && !input.trim().isEmpty() : "Input must be provided for Clear command";
        logList.clearLogs();
    }
}
