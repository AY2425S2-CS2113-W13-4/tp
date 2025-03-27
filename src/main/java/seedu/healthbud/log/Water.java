package seedu.healthbud.log;

public class Water extends Log {

    private String amount;
    private String time;

    public Water(String amount, String date, String time){
        super(date, "water");
        this.amount = amount;
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String toGlass(String amount) {
        double ml = Double.parseDouble(amount.trim());
        double glasses = ml / 250.0;
        return String.format("%.1f glass", glasses);
    }

    @Override
    public String toString() {
        return String.format("%s of water on (%s) at %s", toGlass(amount), getDate(), time);
    }

}
