package seedu.healthbud.log;

public class Meal extends Log {

    private String name;
    private String calories;
    private String time;

    public Meal(String name, String calories, String date, String time){
        super(date, "meal");
        this.name = name;
        this.calories = calories;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String  getCalories() {
        return calories;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s (%s cal) on: %s at: %s", name, calories, getDate(), time);
    }
}
