package seedu.healthbud.log;


public class WorkOUT extends Log {

    private String name;
    private String reps;
    private String sets;
    private String weight;

    public WorkOUT(String name, String reps, String sets, String date, String weight) {
        super(date, "workout");
        this.name = name;
        this.reps = reps;
        this.sets = sets;
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

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s (%s sets of %s kg for %s reps) on %s", name, sets,weight ,reps, getDate());
    }
}
