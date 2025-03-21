package seedu.healthbud.log;

public class PB extends Log {
    private String exercise;
    private String weight;

    public PB(String exercise, String weight, String date){
        super(date);
        this.exercise = exercise;
        this.weight = weight;
    }

    public String getExercise() {
        return exercise;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format(" %s %s kg on (%s)", exercise, weight, getDate());
    }
}
