package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.Ui;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;

public class AddGoalCommand extends OneLogCommand {

    private static String waterGoal ;
    private static String calorieGoal;
    private static String weightGoal;
    private static String weeklyWeightProgress;
    Goals goal = Goals.getInstance();

    public AddGoalCommand(LogList goalLogs, String input, String waterGoal,
                          String calorieGoal, String weightGoal){
        super(goalLogs, input);
        this.waterGoal = waterGoal;
        this.calorieGoal = calorieGoal;
        this.weightGoal = weightGoal;
    }

    public void execute(){
        goal.updateGoals(waterGoal, calorieGoal, weightGoal);
        Ui.printMessage("Goal has been updated:\n" + goal.toString());
    }
}
