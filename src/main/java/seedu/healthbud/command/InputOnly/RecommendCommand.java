package seedu.healthbud.command.InputOnly;

import seedu.healthbud.Ui;

public class RecommendCommand extends InputOnlyCommand {

    private final String list;

    public RecommendCommand(String list) {
        super(list);
        this.list = list;
    }

    @Override
    public void execute() {
        Ui.printMessage(list);
    }
}
