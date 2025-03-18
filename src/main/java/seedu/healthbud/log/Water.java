package seedu.healthbud.log;

public class Water extends Log{

    private String amount;
    private String glasses;
    private String time;
    private String date;

    public Water(String name, String amount, String glasses){
        super(name);
        this.amount = amount;
        this.glasses = glasses;
        this.time = time;
        this.date = date;
    }

    public String getAmount() { return amount; }

    public String getGlasses() { return glasses; }

    public String getTime() { return time; }

    public String getDate() { return date; }

    public String toString() {
        return String.format("%s %s glasses, %s ml on %s at %s", super.toString(), glasses, amount, date, time);
    }
}
