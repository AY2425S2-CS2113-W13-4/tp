package seedu.healthbud.log;

public class Workout {
    private String date;
    private String exercise;
    private int reps;
    private int sets;

    public Workout(String date, String exercise, int reps, int sets) {
        this.date = date;
        this.exercise = exercise;
        this.reps = reps;
        this.sets = sets;
    }

    @Override
    public String toString() {
        return date + " - " + exercise + " (" + reps + " reps, " + sets + " sets)";

    }

}
