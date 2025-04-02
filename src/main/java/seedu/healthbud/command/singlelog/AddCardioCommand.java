package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Cardio;

//@@author Ahmish15
public class AddCardioCommand extends SingleLogCommand {

    private final String name;
    private final String sets;
    private final String intensity;
    private final String time;
    private final String date;

    public AddCardioCommand(LogList cardioLogs, String input, String name, String sets,
                            String intensity, String time, String date) {
        super(cardioLogs, input);
        this.name = name;
        this.sets = sets;
        this.intensity = intensity;
        this.time = time;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getSets() {
        return sets;
    }

    public String getIntensity() {
        return intensity;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }


    @Override
    public void execute() {
        Cardio newCardio = new Cardio(name, sets, intensity, time, date);
        logList.addLog(newCardio);
    }

}
