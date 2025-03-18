package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.log.Meal;

public class AddLogCommand extends Command {

    @Override
    public void execute(LogList logs, String input) throws InvalidMealException {

        String[] parts = input.trim().split(" ");

        switch (parts[0]) {
        case "water":
            Ui.printMessage(" feature not implemented yet");
            break;

        case "meal":
            if (!input.contains("/d") || !input.contains("/t") || !input.contains("/cal")) {
                throw new InvalidMealException();
            }

            String[] meal = input.substring(5).split("/");

            if (meal.length != 4) {
                throw new InvalidMealException();
            }
            meal[1] = meal[1].substring(3).trim();
            meal[2] = meal[2].substring(1).trim();
            meal[3] = meal[3].substring(1).trim();
            if (meal[1].isEmpty() || meal[2].isEmpty() || meal[3].isEmpty()) {
                throw new InvalidMealException();
            }

            Meal newMeal = new Meal(meal[0].trim(), meal[1], meal[2], meal[3]);
            logs.addlog(newMeal);

            Ui.printMessage(" Got it. I've added this meal:");
            Ui.printMessage("   " + logs.getLog(logs.getSize() - 1));
            Ui.printMessage(" Now you have " + logs.getSize() + " meals in the list.");
            break;
            
        default:
            Ui.printMessage("Invalid type of log");
        }
    }
}
