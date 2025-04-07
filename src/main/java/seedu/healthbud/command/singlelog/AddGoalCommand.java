package seedu.healthbud.command.singlelog;

import seedu.healthbud.Ui;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Goals;
import seedu.healthbud.LogList;
import seedu.healthbud.storage.Storage;

public class AddGoalCommand extends SingleLogCommand {
    //@@author keanneeee
    private String waterGoal ;
    private String calorieGoal;
    private String weightGoal;

    Goals goal = Goals.getInstance();

    public AddGoalCommand(LogList goalLogs, String waterGoal,
                          String calorieGoal, String weightGoal){
        super(goalLogs);
        this.waterGoal = waterGoal;
        this.calorieGoal = calorieGoal;
        this.weightGoal = weightGoal;
    }

    public void execute(){
        if (!waterGoal.equals(goal.getDailyWaterGoal())
                || !calorieGoal.equals(goal.getDailyCalorieGoal()) || !weightGoal.equals(goal.getWeightGoal())) {
            goal.updateGoals(waterGoal, calorieGoal, weightGoal);
            Ui.printMessage("Goal has been updated:\n" + goal.toString());
            Storage.appendLogToFile(goal);
        } else {
            goal.updateGoals(waterGoal, calorieGoal, weightGoal);
            Ui.printMessage("Goal has been updated:\n" + goal.toString());
        }
    }
}
