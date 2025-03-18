package seedu.healthbud;

import java.util.Scanner;

public class HealthBud {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static LogList logs = new LogList();

    public static void main(String[] args) {

        Ui.printGreeting();
        Scanner in = new Scanner(System.in);

        boolean isLooping = true;
        while (isLooping) {
            isLooping = Parser.handleInput(logs, in.nextLine().trim());
        }
    }
}
