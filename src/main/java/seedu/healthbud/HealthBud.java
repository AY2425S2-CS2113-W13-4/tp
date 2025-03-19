package seedu.healthbud;

//import seedu.healthbud.storage.Storage;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class HealthBud {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static LogList mealLogs = new LogList();
    public static LogList workoutLogs = new LogList();
    public static LogList waterLogs = new LogList();

    public static void main(String[] args) {

        assert false : "dummy assertion set to fail";
        Ui.printGreeting();
        //Storage.loadMeals(mealLogs);
        Scanner in = new Scanner(System.in);

        boolean isLooping = true;
        while (isLooping) {
            isLooping = Parser.handleInput(mealLogs, workoutLogs, waterLogs, in.nextLine().trim());
        }
    }
}
