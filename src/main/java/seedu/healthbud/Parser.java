package seedu.healthbud;

import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidWorkoutReccException;
import seedu.healthbud.log.Meal;

public class Parser {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList logs, String input) {
        try {
            String command = input.split(" ")[0].toLowerCase();
            switch (command) {
            case "bye":
                return Ui.printGoodbye();
            case "meal":
                handleMeal(logs, input);
                return true;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                handleMealList(logs);
                return true;
            case "recommend":
                recommendWorkout(input);
                return true;
            default:
                Ui.printUnknownCommand();
                return true;
            }
        } catch (InvalidMealException | InvalidWorkoutReccException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void handleMeal(LogList logs, String input) throws InvalidMealException{
        if (input == null || !input.contains("/d") || !input.contains("/t") || !input.contains("/cal")) {
            throw new InvalidMealException();
        }

        String[] meal = input.substring(5).split("/");

        if(meal.length != 4){
            throw new InvalidMealException();
        }
        meal[1] = meal[1].substring(3);
        meal[2] = meal[2].substring(1);
        meal[3] = meal[3].substring(1);
        if (meal[1].isEmpty() || meal[2].isEmpty() || meal[3].isEmpty()) {
            throw new InvalidMealException();
        }

        Meal newMeal = new Meal(meal[0].trim(), meal[1].trim(), meal[2].trim(), meal[3].trim());
        logs.addlog(newMeal);

        Ui.printMessage(" Got it. I've added this meal:");
        Ui.printMessage("   " + logs.getLog(logs.getSize() - 1));
        Ui.printMessage(" Now you have " + logs.getSize() + " meals in the list.");
    }

    public static void handleMealList(LogList logs){
        if (logs.isEmpty()) {
            Ui.printMessage(" No tasks available.");
        } else {
            for (int i = 0; i < logs.getSize(); i++) {
                Ui.printListedFormat(logs, i);
            }
        }
    }

    public static void recommendWorkout(String input) throws InvalidWorkoutReccException{
        if (input == null || !input.contains("/m")) {
            throw new InvalidWorkoutReccException();
        }

        String muscle = input.substring(12).trim().toLowerCase();

        try {
            switch (muscle){
            case "chest":
                System.out.println("Here are some recommended chest exercises: " + NEW_LINE
                        + "1. Incline Smith Machine Bench Press" + NEW_LINE
                        + "2. Dumbbell Chest Press" + NEW_LINE
                        + "3. Cable Chest Flys");
                break;

            case "back":
                System.out.println("Here are some recommended back exercises: " + NEW_LINE
                        + "1. Pull-Ups" + NEW_LINE
                        + "2. Barbell Bent-over Rows" + NEW_LINE
                        + "3. Lat Pulldown");
                break;

            case "biceps":
                System.out.println("Here are some recommended biceps exercises: " + NEW_LINE
                        + "1. Barbell Bicep Curls" + NEW_LINE
                        + "2. Hammer Curls" + NEW_LINE
                        + "3. Cable Curls");
                break;

            case "triceps":
                System.out.println("Here are some recommended triceps exercises: " + NEW_LINE
                        + "1. Close-Grip Bench Press" + NEW_LINE
                        + "2. Tricep Dips" + NEW_LINE
                        + "3. Skull Crushers");
                break;

            case "legs":
                System.out.println("Here are some recommended leg exercises: " + NEW_LINE
                        + "1. Barbell Squats" + NEW_LINE
                        + "2. Leg Extension & Leg Curls" + NEW_LINE
                        + "3. Leg Press");
                break;

            case "shoulders":
                System.out.println("Here are some recommended shoulder exercises: " + NEW_LINE
                        + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
                        + "2. Lateral Raises (Side Delt)" + NEW_LINE
                        + "3. Rear Delt Flys (Rear Delt)");
                break;

            case "abs":
                System.out.println("Here are some recommended ab exercises: " + NEW_LINE
                        + "1. Hanging Leg Raises" + NEW_LINE
                        + "2. Russian Twists" + NEW_LINE
                        + "3. Planks");
                break;

            case "forearms":
                System.out.println("Here are some recommended forearm exercises: " + NEW_LINE
                        + "1. Wrist Curls" + NEW_LINE
                        + "2. Reverse Wrist Curls" + NEW_LINE
                        + "3. Farmer's Walk");
                break;
            default:
                throw new InvalidWorkoutReccException();
            }
        } catch (InvalidWorkoutReccException e){
            System.out.println(e.getMessage());
        }
    }
}
