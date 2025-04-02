package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.exception.InvalidSumException;

public class SumCommand extends SingleLogCommand {

    private final String type;
    private final String date;

    public SumCommand(String input, LogList logList, String type, String date) {
        super(logList, input);
        this.type = type;
        this.date = date;
    }

    @Override
    public void execute() throws InvalidSumException {
        switch (type) {
        case "cal":
            logList.getCaloriesSum(date);
            break;
        case "vol":
            logList.getWaterSum(date);
            break;
        case "cardio":
            logList.getCardioSum(date);
            break;
        default:
            throw new InvalidSumException();
        }
    }
}
