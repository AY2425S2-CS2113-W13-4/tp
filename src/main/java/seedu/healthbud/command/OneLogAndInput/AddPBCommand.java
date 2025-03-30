package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;
import seedu.healthbud.log.PB;

public class AddPBCommand extends OneLogCommand {

    private final String name;
    private final String weight;
    private final String date;

    public AddPBCommand(LogList pbLogs, String input, String name, String weight, String date) {
        super(pbLogs, input);
        this.name = name;
        this.weight = weight;
        this.date = date;
    }

    @Override
    public void execute() {
        PB newPB = new PB(name, weight, date);
        logList.addLog(newPB);
    }
}
