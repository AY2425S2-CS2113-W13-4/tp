package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.PersonalBest;

//@@ author Ahmish15
public class AddPersonalBestCommand extends SingleLogCommand {

    private final String name;
    private final String weight;
    private final String date;

    public AddPersonalBestCommand(LogList pbLogs, String input, String name, String weight, String date) {
        super(pbLogs, input);
        this.name = name;
        this.weight = weight;
        this.date = date;
    }

    @Override
    public void execute() {
        PersonalBest newPB = new PersonalBest(name, weight, date);
        logList.addLog(newPB);
    }
}
