package seedu.healthbud;

import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.storage.Storage;
import java.util.Scanner;

public class HealthBud {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static LogList mealLogs = new LogList();
    public static LogList workoutLogs = new LogList();
    public static LogList waterLogs = new LogList();
    public static LogList pbLogs = new LogList();
    public static LogList goalLogs = new LogList();
    public static LogList cardioLogs = new LogList();

    public static void main(String[] args) throws HealthBudException {
        Ui.printGreeting();
        Storage.loadLogs(mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs, goalLogs);
        Scanner in = new Scanner(System.in);
        boolean isLooping = true;
        while (isLooping) {
            isLooping = Parser.handleInput(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs,
                    in.nextLine().trim().toLowerCase());
        }
    }
}
