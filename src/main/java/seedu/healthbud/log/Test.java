package seedu.healthbud.log;

public class Test extends Log {

    private String name;
    private String reps;
    private String sets;

    public Test(String name, String reps, String sets, String date) {
        super(date);
        this.name = name;
        this.reps = reps;
        this.sets = sets;
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

    @Override
    public String toString() {
        return String.format("%s (%s sets of %s) on %s", name, sets, reps, getDate());
    }
}
