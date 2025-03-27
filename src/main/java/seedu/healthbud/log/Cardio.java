package seedu.healthbud.log;

public class Cardio extends Log{

    private String name;
    private String duration;
    private String incline;
    private String speed;

    public Cardio(String name, String speed, String incline, String duration, String date) {
        super(date, "cardio");
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
        return name  + " (speed: " + speed + ", incline: " + incline + ", duration: " + duration + " mins) on " +
                getDate();

    }

}
