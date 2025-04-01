package seedu.healthbud.command.onelogandinput;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.exception.InvalidDateFormatException;

public class SearchCommand extends OneLogCommand {
    private final String date;
    private final String keyword;

    public SearchCommand(String input, LogList logList, String date, String keyword) {
        super(logList, input);
        this.date = date;
        this.keyword = keyword;
    }

    @Override
    public void execute() throws InvalidDateFormatException {
        // Ensure exactly one of date or keyword is provided
        if ((date != null && keyword != null) || (date == null && keyword == null)) {
            Ui.printMessage("Invalid search parameters. Provide either /d <date> or /k <keyword>, but not both.");
            return;
        }

        if (date != null) {
            // Search by date
            Ui.printMessage("Showing logs for date: " + date);
            boolean foundAny = printLogsForDate(logList, date);
            if (!foundAny) {
                Ui.printMessage("No logs found for this date.");
            }
        } else {
            // Search by keyword
            Ui.printMessage("Showing logs containing keyword: " + keyword);
            logList.findLog(keyword);
        }
    }

    private boolean printLogsForDate(LogList logs, String date) {
        boolean found = false;
        for (int i = 0; i < logs.getSize(); i++) {
            if (logs.getLog(i).getDate().equals(date)) {
                Ui.printMessage(logs.getLog(i).toString());
                found = true;
            }
        }
        return found;
    }
}
