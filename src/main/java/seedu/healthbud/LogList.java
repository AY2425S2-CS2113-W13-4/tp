package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.log.Log;
import seedu.healthbud.log.Meal;

import java.util.ArrayList;
import java.util.List;
import seedu.healthbud.storage.Storage;

public class LogList {

    private List<Log> logs;

    public LogList(){
        logs = new ArrayList<>();
    }


    public Log getLog(int index){
        return logs.get(index);
    }


    public int getSize() {
        return logs.size();
    }

    public boolean isEmpty() {
        return logs.isEmpty();
    }

    public void addlog(Log log) {
        logs.add(log);
    }

    public void deleteLog(int index) throws HealthBudException {

        if (index < 1 || index > getSize()) {
            throw new HealthBudException("Task number not in range");
        }

        Ui.printMessage(" Noted. I've removed this log:");
        Ui.printMessage("  " + getLog(index - 1));
        logs.remove(index - 1);
        Storage.rewriteLogsToFile(this);
        Ui.printMessage(" Now you have " + getSize() + " logs in the list.");
    }

    public void listLogs() {
        if (logs.isEmpty()) {
            Ui.printMessage(" No tasks available.");
        } else {
            for (int i = 0; i < logs.size(); i++) {
                Ui.printListedFormat(this, i);
            }
        }
    }

    public void findLog(String keyword) {
        boolean notFound = true;
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).toString().contains(keyword)) {
                notFound = false;
                Ui.printListedFormat(this, i);
            }
        }

        if (notFound) {
            Ui.printMessage("No matching '" + keyword +  "' tasks found.");
        }
    }

    public void clearLogs() {
        logs.clear();
        Storage.rewriteLogsToFile(this);
        Ui.printMessage(" Noted. I've removed all logs.");
    }

    public void getCaloriesSum(String date) {
        int totalCalories = 0;
        for (int i = 0; i < logs.size(); i++) {
            Meal meal = (Meal) logs.get(i);
            if (meal.getDate().equals(date)) {
                totalCalories += Integer.parseInt(meal.getCalories());
            }
        }
        Ui.printMessage("Total calories consumed: " + totalCalories);
    }
}

