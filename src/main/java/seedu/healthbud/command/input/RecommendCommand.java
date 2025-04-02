package seedu.healthbud.command.input;

import seedu.healthbud.Ui;
import seedu.healthbud.command.InputCommand;

public class RecommendCommand extends InputCommand {

    private final String list;

    public RecommendCommand(String list) {
        super(list);
        this.list = list;
    }

    public String getMessage() {
        return list;
    }

    @Override
    public void execute() {
        Ui.printMessage(list);
    }
}
