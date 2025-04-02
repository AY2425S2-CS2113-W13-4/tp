package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Water;


//@@ author Ahmish15
public class AddWaterCommand extends SingleLogCommand {

    private final String ml;
    private final String date;
    private final String time;

    public AddWaterCommand(LogList waterLogs, String input, String ml, String date, String time) {
        super(waterLogs, input);
        this.ml = ml;
        this.date = date;
        this.time = time;
    }

    @Override
    public void execute(){
        Water newWater = new Water(ml, date, time);
        logList.addLog(newWater);
    }
}
