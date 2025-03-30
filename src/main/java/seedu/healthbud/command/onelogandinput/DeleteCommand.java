package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;

public class DeleteCommand extends OneLogCommand {

    private final int index;

    public DeleteCommand(LogList targetLogList, String input, int index) {
        super(targetLogList, input);
        this.index = index;
    }

    @Override
    public void execute() throws HealthBudException {
        if (!input.trim().matches(".*\\d+.*")) {
            throw new HealthBudException("Insert a valid task number");
        }

        logList.deleteLog(index);
    }
}
