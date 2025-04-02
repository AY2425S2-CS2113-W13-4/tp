package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.exception.HealthBudException;

public class DeleteCommand extends SingleLogCommand {

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

    public LogList getLogList() {
        return logList;
    }

    public int getIndex() {
        return index;
    }
}
