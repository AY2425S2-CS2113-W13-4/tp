package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Meal;

public class AddMealCommand extends OneLogCommand {

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
