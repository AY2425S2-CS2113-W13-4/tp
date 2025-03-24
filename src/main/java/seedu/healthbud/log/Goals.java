package seedu.healthbud.log;

public class Goals extends Log {

    private static Goals instance;
    private String dailyWaterGoal;
    private String dailyCalorieGoal;
    private String weightGoal;
    private String weeklyWeightProgress;

    private Goals(String dailyWaterGoal, String dailyCalorieGoal,
                  String weightGoal, String weeklyWeightProgress, String date) {
        super(date);
        this.dailyWaterGoal = dailyWaterGoal;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.weightGoal = weightGoal;
        this.weeklyWeightProgress = weeklyWeightProgress;
    }

    public static Goals getInstance() {
        if (instance == null) {
            instance = new Goals(null, null, null, null, null);
        }
        return instance;
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
        return String.format("    Daily Water Goal: %s ml\n"
                + "    Daily Calorie Goal: %s cal\n"
                + "    Weight Goal: %s kg\n"
                + "    Weekly Weight Progress: %s kg\n"
                , dailyWaterGoal, dailyCalorieGoal, weightGoal, weeklyWeightProgress);
    }
}
