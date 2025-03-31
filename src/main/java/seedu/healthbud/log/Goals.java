package seedu.healthbud.log;

public class Goals extends Log {

    private static Goals instance;
    private String dailyWaterGoal;
    private String dailyCalorieGoal;
    private String weightGoal;
    private String weeklyWeightProgress;

    private Goals(String dailyWaterGoal, String dailyCalorieGoal,
                  String weightGoal, String weeklyWeightProgress, String date) {
        super(date, "goals");
        this.dailyWaterGoal = dailyWaterGoal;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.weightGoal = weightGoal;
        this.weeklyWeightProgress = weeklyWeightProgress;
    }

    public static Goals getInstance() {
        if (instance == null) {
            instance = new Goals("0", "0", "0", "0", "0");
        }
        return instance;
    }

    public void updateGoals(String water, String calorie, String weight){
        this.dailyWaterGoal = water;
        this.dailyCalorieGoal = calorie;
        this.weightGoal = weight;
    }

    public void setDailyWaterGoal(String dailyWaterGoal) {
        this.dailyWaterGoal = dailyWaterGoal;
    }

    public void setDailyCalorieGoal(String dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public void setWeightGoal(String weightGoal) {
        this.weightGoal = weightGoal;
    }

    public void setWeeklyWeightProgress(String weeklyWeightProgress) {
        this.weeklyWeightProgress = weeklyWeightProgress;
    }

    public String getDailyWaterGoal() {
        return dailyWaterGoal;
    }

    public String getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public String getWeeklyWeightProgress() {
        return weeklyWeightProgress;
    }


    public String toString() {
        Goals goal = Goals.getInstance();
        String finalString;
        if (goal.getDailyWaterGoal().equals("0")) {
            finalString = "    Daily Water Goal: Not set yet\n";
        } else {
            finalString = "    Daily Water Goal: " + goal.getDailyWaterGoal() + " ml\n";
        }

        if (goal.getDailyCalorieGoal().equals("0")) {
            finalString += "    Daily Calorie Goal: Not set yet\n";
        } else {
            finalString += "    Daily Calorie Goal: " + goal.getDailyCalorieGoal() + " cal\n";
        }
        if (goal.getWeightGoal().equals("0")) {
            finalString += "    Weight Goal: Not set yet\n";
        } else {
            finalString += "    Weight Goal: " + goal.getWeightGoal() + " kg\n";
        }
        return finalString;
    }
}
