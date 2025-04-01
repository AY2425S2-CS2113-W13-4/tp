package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Workout;


//@@ author Ahmish15
public class AddWorkoutCommand extends OneLogCommand {

    private final String name;
    private final String reps;
    private final String sets;
    private final String date;
    private final String weight;

    public AddWorkoutCommand(LogList workoutLogs, String input, String name,
                             String reps, String sets, String date, String weight) {
        super(workoutLogs, input);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.date = date;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getReps() {
        return reps;
    }

    public String getSets() {
        return sets;
    }

    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public void execute(){
        Workout newWorkout = new Workout(name, reps, sets, date, weight);
        logList.addLog(newWorkout);
    }

}
