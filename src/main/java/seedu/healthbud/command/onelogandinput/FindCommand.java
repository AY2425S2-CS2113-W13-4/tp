package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;

public class FindCommand extends OneLogCommand {

    private final String keyword;

    public FindCommand(String input, LogList logList, String keyword) {
        super(logList, input);
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        logList.findLog(keyword);
    }
}
