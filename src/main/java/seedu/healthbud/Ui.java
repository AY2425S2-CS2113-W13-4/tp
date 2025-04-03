package seedu.healthbud;

public class Ui {

    /**
     * New line and indent used for formatting output.
     */
    public static final String NEW_LINE = "\n    ";

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
        System.out.println("""
                ⠀⠀⠀⠀⠀⠀ ⠀⣀⣴⣶⣶⣶⡦⠤⣀⡀⠀⠀⠀⠀⠀⣀⣤⣤⣀⡀⠀⠀⠀⠀⠀⣀⣤⣴⡶⣶⣶⡦⣄⡀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⣀⣴⡾⢛⣡⣿⣤⡄⡕⡇⠹⡇⠀⠀⠀⠀⣾⣿⠿⠻⣿⣿⡄⠀⠀⠀⢸⠻⠸⠹⠁⣤⣿⣦⡙⠿⣦⣄⡀⠀⠀⠀⠀
                ⠀⣠⣾⡿⠟⠁⡴⢫⡾⠋⠘⠻⢷⣷⣾⠇⠀⠀⠀⢰⠛⣿⣟⣿⣿⡿⣧⠀⠀⠀⠘⢾⣴⡷⠿⠃⠈⢿⣎⢳⡈⠙⠿⣵⣦⡀⠀
                ⢸⡿⠁⠀⠀⣼⣷⣿⢃⡀⠀⠀⠀⠈⠁⠀⠀⠀⠀⢘⢧⣄⢽⣼⣄⣴⡟⠀⠀⠀⠀  ⠈⠉⠀⠀⠀  ⢀⡈⣿⣿⣳⡀⠀⠀⢹⣷⠀
                ⣿⣧⡀⢤⣼⣭⡿⠿⠭⣘⢷⣤⠶⠉⠑⢦⣄⠀⠀⢸⣦⡍⠩⠿⠏⣵⣿⠀⠀⢀⣴⠖⠉⠵⣦⣴⢓⡩⠽⢿⣯⣵⣤⠄⣸⣿⡄
                ⢿⣿⡭⣡⣤⢽⣧⡀⠀⠀⠙⣿⣶⣤⠀⠙⠛⠶⣶⣿⣻⣷⣾⣿⣾⣿⣸⣵⠶⠟⠛⠁⢠⣴⣿⠟⠁⠀⠀⣠⡿⠬⡥⡩⢿⡷⠃
                ⠀⠉⠳⣶⣿⣞⣿⣧⣄⣀⣠⣾⣿⣿⡯⢄⠀⠀⠀⠩⣝⣻⣿⣿⡿⣛⠉⠀⠀⠀⣀⠬⣿⣿⣿⣄⣀⣀⣼⣿⣛⣾⣶⡶⠋⠀⠀
                ⠀⠀⠀⠙⢦⡀⠀⠙⢿⣿⣿⣿⣭⢿⣿⣦⣄⠀⠀⠀⠠⢿⣿⣿⣿⠅⠀⠀⠀⣀⣤⣾⣿⢯⣿⣿⣿⣿⠟⠁⠀⣴⠟⠀⠀⠀⠀
                ⠀⠀⠀⠀⠈⠛⠶⣶⠿⠿⡿⠃⡼⠀⢻⣿⣿⣿⣶⣶⣶⣾⣿⣿⣿⣶⣶⣶⣾⣿⣿⣿⠁⢰⡈⢻⠿⠿⣷⡶⠞⠁⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⣼⣧⠀⣸⣟⣿⣿⣿⠿⠛⠛⢿⣿⠛⠛⠻⢿⣿⢿⣏⣧⠀⣾⣷⣼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣷⣧⡼⠁⣸⣇⣤⣤⣤⣼⣿⣤⣤⣤⣈⣿⡀⢱⣬⣷⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣴⡇⢸⡿⠋⠀⠀⠀⢻⣿⠁⠀⠀⠉⢻⡇⢸⣧⣼⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⡟⢄⣷⣤⣤⣶⢶⣿⣾⣶⠶⣦⣤⣼⣧⢜⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⡈⢻⠏⠁⠀⠀⢹⣿⠁⠀⠀⠙⣿⠋⣾⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣯⢻⣇⠀⠀⢀⣾⣿⣄⠀⠀⢠⡿⢹⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣎⠂⢿⠛⠉⠉⠙⡟⠉⠉⠙⢻⠃⢢⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣄⣼⣆⠀⠀⠀⠁⠀⠀⢀⣾⣄⣾⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠿⣦⣤⣤⣦⣤⣴⡾⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                """);
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
                + "1. help - Display this list of commands" + NEW_LINE
                + "2. bye - Exit the program" + NEW_LINE
                + "3. recommend <muscle_group> - Get workout recommendations" + NEW_LINE
                + "4. bmi /w <weight_in_kg> /h <height_in_m> - Calculate your BMI" + NEW_LINE
                + "5. add workout <exercise> /w <weight in kg> /r <reps> /s <sets> /d <DD/MM/YYYY> " +
                "- Add a workout log" + NEW_LINE
                + "6. add meal <meal_name> /cal <calories> /d <DD/MM/YYYY> /t <time> - Add a meal log" + NEW_LINE
                + "7. add water /ml <volume> /d <DD/MM/YYYY> /t <time> - Add a water log" + NEW_LINE
                + "8. add pb <exercise> /w <weight_in_kg> /d <DD/MM/YYYY> - Record a personal best" + NEW_LINE
                + "9. sum <cal|vol> /d <DD/MM/YYYY> - Sum up the total calories/water for the day" + NEW_LINE
                + "10. clear <pb|meal|workout|water> - Clear the respective log" + NEW_LINE
                + "11. add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <DD/MM/YYYY> - Add a cardio log"
                + NEW_LINE
                + "12. view goals - to view all goals" + NEW_LINE
                + "13  add goal /w <waterGoals /c <calorieGoals> /m <weightGoals> - to edit personal goals" + NEW_LINE
                + "14. status change <cutting/bulking> - Update your cutting/bulking status." + NEW_LINE
                + "15. status report - View your current cutting/bulking progress" + NEW_LINE
                + "16. search <logType> /d <DD/MM/YYYY> OR search <logType> /k <keyword> - Search for logs" + NEW_LINE);
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
