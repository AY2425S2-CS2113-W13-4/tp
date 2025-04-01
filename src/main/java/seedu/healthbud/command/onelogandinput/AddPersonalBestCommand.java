package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.log.PersonalBest;

//@@ author Ahmish15
public class AddPersonalBestCommand extends OneLogCommand {

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
