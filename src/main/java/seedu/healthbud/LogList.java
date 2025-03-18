package seedu.healthbud;

import seedu.healthbud.log.Log;
import seedu.healthbud.log.Workout;
import java.util.ArrayList;
import java.util.List;

public class LogList {

    private List<Log> logs;
    private List<Workout> workouts;

    public LogList(){
        logs = new ArrayList<>();
        workouts = new ArrayList<>();
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public Log getLog(int index){
        return logs.get(index);
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public int getWorkoutSize() {
        return workouts.size();
    }

    public int getSize() {
        return logs.size();
    }

    public boolean isEmpty() {
        return logs.isEmpty() && workouts.isEmpty();
    }

    public void addlog(Log log) {
        logs.add(log);
    }

}

