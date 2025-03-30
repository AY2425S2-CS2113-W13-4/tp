package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.log.Log;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.Water;


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
        Ui.printMessage(" Got it. I've added this log:" + log.getLogType());
        Ui.printMessage("  " + getLog(getSize() - 1));
        Storage.appendLogToFile(log);
        Ui.printMessage(String.format(" Now you have %d %s logs in the list.", getSize(), log.getLogType()));
    }

    public void loadLog(Log log) {
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
            Ui.printMessage(" No logs available.");
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
            Ui.printMessage("No matching '" + keyword +  "' logs found.");
        }
    }

    public void clearLogs() {
        if (logs.isEmpty()) {
            Ui.printMessage("No logs to clear.");
            return;
        }
        logs.clear();
        Storage.rewriteLogsToFile(this);
        Ui.printMessage("Noted. I've removed all logs.");
    }

    public void getAllDates(){
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < logs.size(); i++) {
            String date = logs.get(i).getDate();
            if (!dates.contains(date)) {
                dates.add(date);
            }
        }
        Ui.printMessage("Here are the dates available:");
        for (int i = 0; i < dates.size(); i++) {
            Ui.printMessage((i + 1) + ". " + dates.get(i));
        }
    }

    public int getCaloriesSum(String date) {
        int totalCalories = 0;
        for (int i = 0; i < logs.size(); i++) {
            Meal meal = (Meal) logs.get(i);
            if (meal.getDate().equals(date)) {
                totalCalories += Integer.parseInt(meal.getCalories());
            }
        }
        Ui.printMessage("Total calories consumed: " + totalCalories);
        return totalCalories;
    }

    public int getCardioSum(String date){
        int totalCardio = 0;
        for (int i = 0; i < logs.size(); i++) {
            Cardio cardio = (Cardio) logs.get(i);
            if(cardio.getDate().equals(date)){
                int speed = Integer.parseInt(cardio.getSpeed());
                int duration = Integer.parseInt(cardio.getDuration());
                int incline = Integer.parseInt(cardio.getIncline());

                // general formula that i got from chat idk it might be anyhow de - kin
                // Calories = (Speed * 2) + (Incline * 5) * (Duration / 60.0) * 100
                totalCardio += (int) (((speed * 2) + (incline * 5)) * (duration / 60.0) * 100);
            }
        }
        Ui.printMessage("Total calories burned: " + totalCardio);
        return totalCardio;
    }

    public void getWaterSum(String date) {
        int totalWater = 0;
        for (int i = 0; i < logs.size(); i++) {
            Water water = (Water) logs.get(i);
            if (logs.get(i).getDate().equals(date)) {
                totalWater += Integer.parseInt(water.getAmount());
            }
        }
        Ui.printMessage("Total water consumed: " + totalWater + "ml");
    }
}

