package seedu.healthbud.log;

public class Water extends Log {

    private String amount;
    private String time;

    public Water(String name, String amount, String date, String time){
        super(name, date);
        this.amount = amount;
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String toString() {
        return String.format("%s, %s ml on %s at %s", getName(), amount, getDate(), getTime());
    }

}
