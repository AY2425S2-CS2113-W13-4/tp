package seedu.healthbud.command.singlelog;

import seedu.healthbud.LogList;
import seedu.healthbud.command.SingleLogCommand;
import seedu.healthbud.log.Meal;

//@@ author Ahmish15
public class AddMealCommand extends SingleLogCommand {

    private final String name;
    private final String calories;
    private final String date;
    private final String time;

    public AddMealCommand(LogList mealLogs, String input, String name, String calories, String date, String time) {
        super(mealLogs, input);
        this.name = name;
        this.calories = calories;
        this.date = date;
        this.time = time;
    }

    @Override
    public void execute() {
        Meal newMeal = new Meal(name, calories, date, time);
        logList.addLog(newMeal);
    }
}
