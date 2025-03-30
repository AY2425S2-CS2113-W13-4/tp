package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;

public class ClearCommand extends OneLogCommand {
    private final String logType;

    public ClearCommand(String input, LogList logList, String logType) {
        super(logList, input);
        this.logType = logType.toLowerCase();
    }

    @Override
    public void execute() {
        assert input != null && !input.trim().isEmpty() : "Input must be provided for Clear command";
        logList.clearLogs();
    }
}
