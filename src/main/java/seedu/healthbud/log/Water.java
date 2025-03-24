package seedu.healthbud.log;

public class Water extends Log {
    private static int glass;
    private static int bottle;
    private String amount;
    private String time;

    public Water(String amount, String date, String time){
        super(date);

        this.amount = amount;
        this.time = time;
        updateVariables(amount);
    }

    public String getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s ml on (%s) at %s", amount, getDate(), time);
    }

    public void updateVariables(String amount) {
        int amountInt = Integer.parseInt(amount);
        this.glass = amountInt/250;
        this.bottle = amountInt/1000;
    }

}
