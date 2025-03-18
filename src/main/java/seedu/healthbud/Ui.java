package seedu.healthbud;

public class Ui {

    /** New line and indent used for formatting output. */
    public static final String NEW_LINE = "\n     ";

    /**
     * Prints a message with indentation.
     *
     * @param message the message to print
     */
    public static void printMessage(String message) {
        System.out.println("    " + message);
    }

    /**
     * Prints Terry in ASCII to the user.
     */
    public static void printHealthBuds() {
        System.out.println("  _   _            _ _   _     ____            _ ");
        System.out.println(" | | | | ___  __ _| | |_| |__ | __ ) _   _  __| |");
        System.out.println(" | |_| |/ _ \\/ _` | | __| '_ \\|  _ \\| | | |/ _` |");
        System.out.println(" |  _  |  __/ (_| | | |_| | | | |_) | |_| | (_| |");
        System.out.println(" |_| |_|\\___|\\__,_|_|\\__|_| |_|____/ \\__,_|\\__,_|");
    }

    /**
     * Prints the greeting message to the user.
     */
    public static void printGreeting() {
        printHealthBuds();
        printMessage("Hello! I'm HealthBud" + NEW_LINE + "What can I do for you?");
    }

    /**
     * Prints the goodbye message and returns false to signal the termination of the program.
     *
     * @return false to indicate that the program should exit
     */
    public static boolean printGoodbye() {
        printMessage("Bye. Hope to see you again soon!");
        return false;
    }

    /**
     * Prints the list of available commands for the user.
     */
    public static void printHelp() {
        printMessage("Here are the commands you can use:" + NEW_LINE
                + "1. Meal <meal name> /cal <calories> /d <date> /t <time> - Add a meal log" + NEW_LINE
                + "2. Bye - Exit the program" + NEW_LINE
                + "3. Recommend <muscle_group>" + NEW_LINE
                + "4. bmi /w <weight_in_kg> /h <height_in_m> - Calculate your BMI" + NEW_LINE
                + "5. add <date> /e <exercise> /r <reps> /s <sets> ");
    }

    /**
     * Prints a message indicating that the entered command is unknown.
     */
    public static void printUnknownCommand() {
        printMessage("I don't recognize that command. Type 'help' to see the list of commands.");
    }

    public static void printListedFormat(LogList logs, int index) {
        printMessage((index + 1) + ". " + logs.getLog(index));
    }
}
