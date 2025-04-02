package seedu.healthbud.command;

import seedu.healthbud.LogList;

// FOR COMMANDS THAT ONLY NEED ONE LOG AT A TIME AND INPUT

public abstract class SingleLogCommand implements Command {
    protected final LogList logList;
    protected final String input;

    public SingleLogCommand(LogList logList, String input) {
        this.logList = logList;
        this.input = input;
    }
}
