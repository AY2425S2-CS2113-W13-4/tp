package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;
import seedu.healthbud.command.CommandInterface.Command;

// FOR COMMANDS THAT ONLY NEED ONE LOG AT A TIME AND INPUT

public abstract class OneLogCommand implements Command {
    protected final LogList logList;
    protected final String input;

    public OneLogCommand(LogList logList, String input) {
        this.logList = logList;
        this.input = input;
    }
}
