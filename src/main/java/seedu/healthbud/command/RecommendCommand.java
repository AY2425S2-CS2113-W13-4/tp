package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.HealthBudException;

public class RecommendCommand extends Command {

    private static final String NEW_LINE = "\n     ";

    @Override
    public void execute(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                        LogList waterLogs, LogList cardioLogs, String input) throws
            InvalidRecommendException, HealthBudException {

        String recommendation = getRecommendation(input);
        System.out.println(recommendation); // Only print in execute, but we can test getRecommendation separately
    }

    public String getRecommendation(String input) throws InvalidRecommendException, HealthBudException {
        assert input != null : "Input should not be null";
        assert !input.trim().isEmpty() : "Input should not be empty";

        if (!input.contains(" ")) {
            throw new InvalidRecommendException();
        }

        String muscle = input.substring(10).trim();

        switch (muscle) {
        case "chest":
            return "Here are some recommended chest exercises:" + NEW_LINE
                    + "1. Incline Smith Machine Bench Press" + NEW_LINE
                    + "2. Dumbbell Chest Press" + NEW_LINE
                    + "3. Cable Chest Flys";

        case "back":
            return "Here are some recommended back exercises:" + NEW_LINE
                    + "1. Pull-Ups" + NEW_LINE
                    + "2. Barbell Bent-over Rows" + NEW_LINE
                    + "3. Lat Pulldown";

        case "biceps":
            return "Here are some recommended biceps exercises:" + NEW_LINE
                    + "1. Barbell Bicep Curls" + NEW_LINE
                    + "2. Hammer Curls" + NEW_LINE
                    + "3. Cable Curls";

        case "triceps":
            return "Here are some recommended triceps exercises:" + NEW_LINE
                    + "1. Close-Grip Bench Press" + NEW_LINE
                    + "2. Tricep Dips" + NEW_LINE
                    + "3. Skull Crushers";

        case "legs":
            return "Here are some recommended leg exercises:" + NEW_LINE
                    + "1. Barbell Squats" + NEW_LINE
                    + "2. Leg Extension & Leg Curls" + NEW_LINE
                    + "3. Leg Press";

        case "shoulders":
            return "Here are some recommended shoulder exercises:" + NEW_LINE
                    + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
                    + "2. Lateral Raises (Side Delt)" + NEW_LINE
                    + "3. Rear Delt Flys (Rear Delt)";

        case "abs":
            return "Here are some recommended ab exercises:" + NEW_LINE
                    + "1. Hanging Leg Raises" + NEW_LINE
                    + "2. Russian Twists" + NEW_LINE
                    + "3. Planks";

        case "forearms":
            return "Here are some recommended forearm exercises:" + NEW_LINE
                    + "1. Wrist Curls" + NEW_LINE
                    + "2. Reverse Wrist Curls" + NEW_LINE
                    + "3. Farmer's Walk";

        case "help":
            return "Here are the list of muscle groups:" + NEW_LINE
                    + "1. chest" + NEW_LINE
                    + "2. back" + NEW_LINE
                    + "3. biceps" + NEW_LINE
                    + "4. triceps" + NEW_LINE
                    + "5. legs" + NEW_LINE
                    + "6. shoulders" + NEW_LINE
                    + "7. abs" + NEW_LINE
                    + "8. forearms";

        default:
            throw new HealthBudException("I don't recognize that muscle group." + NEW_LINE
                    + "Type 'rec help' to see the list of muscle groups.");
        }
    }
}
