package seedu.healthbud.command.InputOnly;

import seedu.healthbud.command.CommandInterface.Command;

// FOR COMMANDS THAT OINLY NEED INPUT AND NO NEED LOGS AT ALL

public abstract class InputOnlyCommand implements Command {
    protected String input;

    public InputOnlyCommand(String input) {
        this.input = input;
    }
}

