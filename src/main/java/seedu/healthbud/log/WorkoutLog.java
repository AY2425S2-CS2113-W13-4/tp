package seedu.healthbud.log;

import seedu.healthbud.exception.InvalidWorkoutException;

import java.util.ArrayList;
import java.util.List;

public class WorkoutLog {
    private final String date;
    private final String exercise;
    private final int reps;
    private final int sets;

    // Static list to store all workouts
    private static final ArrayList<WorkoutLog> workouts = new ArrayList<>();

    public WorkoutLog(String date, String exercise, int reps, int sets) throws InvalidWorkoutException {
        // Validate inputs
        if (reps <= 0 || sets <= 0) {
            throw new InvalidWorkoutException("Reps and sets must be positive integers.");
        }
        this.date = date;
        this.exercise = exercise;
        this.reps = reps;
        this.sets = sets;
    }

    // Static method to add a workout
    public static void addWorkout(WorkoutLog workout) {
        workouts.add(workout);
    }

    // Static method to get all workouts
    public static List<WorkoutLog> getWorkouts() {
        return new ArrayList<>(workouts); // Return a copy to prevent external modification
    }

    // Static method to clear all workouts
    public static void clearWorkouts() {
        workouts.clear();
    }

    // Static method to get the number of workouts
    public static int getWorkoutCount() {
        return workouts.size();
    }

    @Override
    public String toString() {
        return date + " - " + exercise + " (" + reps + " reps, " + sets + " sets)";
    }
}