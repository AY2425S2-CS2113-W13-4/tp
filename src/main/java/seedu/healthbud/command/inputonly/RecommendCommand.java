package seedu.healthbud.command.inputonly;

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
