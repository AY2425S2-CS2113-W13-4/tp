package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Cardio;

public class AddCardioCommand extends OneLogCommand {

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

    @Override
    public void execute() {
        Cardio newCardio = new Cardio(name, sets, intensity, time, date);
        logList.addLog(newCardio);
    }
}
