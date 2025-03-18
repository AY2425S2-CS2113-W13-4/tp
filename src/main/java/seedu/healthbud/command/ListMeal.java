package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;

public class ListMeal extends Command {

    @Override
    public void execute(LogList logs, String input) {
        if (logs.isEmpty()) {
            Ui.printMessage(" No tasks available.");
        } else {
            for (int i = 0; i < logs.getSize(); i++) {
                Ui.printListedFormat(logs, i);
            }
        }
    }
}
