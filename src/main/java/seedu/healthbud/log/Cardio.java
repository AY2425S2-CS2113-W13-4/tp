package seedu.healthbud.log;

public class Cardio extends Log{

    private String name;
    private String duration;
    private String incline;
    private String speed;

    public Cardio(String name, String duration, String incline, String speed, String date) {
        super(date);
        this.name = name;
        this.duration = duration;
        this.incline = incline;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getIncline() {
        return incline;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name  + " (" + speed + " speed " + incline + " incline " + duration + " long) on " + getDate();

    }

}
