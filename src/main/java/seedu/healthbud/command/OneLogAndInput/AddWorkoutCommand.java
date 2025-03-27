package seedu.healthbud.command.OneLogAndInput;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.log.WorkOUT;

public class AddWorkoutCommand extends OneLogCommand {

    private final String name;
    private final String reps;
    private final String sets;
    private final String date;

    public AddWorkoutCommand(LogList workoutLogs, String input, String name, String reps, String sets, String date) {
        super(workoutLogs, input);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.date = date;
    }

    @Override
    public void execute() throws InvalidLogException {
        WorkOUT newWorkout = new WorkOUT(name, reps, sets, date);
        logList.addLog(newWorkout);
    }
}