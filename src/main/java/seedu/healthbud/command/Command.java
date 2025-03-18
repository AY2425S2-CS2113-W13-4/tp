package seedu.healthbud.command;

import seedu.healthbud.LogList;

public abstract class Command {
    public abstract void execute(LogList logs, String input) throws Exception;
}
