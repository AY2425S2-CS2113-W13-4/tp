package seedu.healthbud.parser;

import seedu.healthbud.command.input.RecommendCommand;
import seedu.healthbud.exception.InvalidRecommendException;

/**
 * RecommendParser is responsible for parsing the input command for workout recommendations.
 * It validates the input format and returns a RecommendCommand containing a message
 * with recommended exercises for a specific muscle group.
 */
public class RecommendParser {

    private static final String NEW_LINE = "\n     ";

    /**
     * Parses the given input and returns a RecommendCommand with the corresponding recommendations.
     *
     * @param input the input command; must not be null.
     * @return a RecommendCommand with the recommendation message.
     * @throws InvalidRecommendException
     * if the input does not have exactly two parts or the muscle group is unrecognized.
     */
    public static RecommendCommand parse(String input) throws InvalidRecommendException {
        assert input != null : "Input should not be null";
        String[] parts = input.trim().split(" ");
        if (parts.length != 2) {
            throw new InvalidRecommendException();
        }

        switch (parts[1]) {
        case "chest":
            return new RecommendCommand("Here are some recommended chest exercises:" + NEW_LINE
                    + "1. Incline Smith Machine Bench Press" + NEW_LINE
                    + "2. Dumbbell Chest Press" + NEW_LINE
                    + "3. Cable Chest Flys");

        case "back":
            return new RecommendCommand("Here are some recommended back exercises:" + NEW_LINE
                    + "1. Pull-Ups" + NEW_LINE
                    + "2. Barbell Bent-over Rows" + NEW_LINE
                    + "3. Lat Pulldown");

        case "biceps":
            return new RecommendCommand("Here are some recommended biceps exercises:" + NEW_LINE
                    + "1. Barbell Bicep Curls" + NEW_LINE
                    + "2. Hammer Curls" + NEW_LINE
                    + "3. Cable Curls");

        case "triceps":
            return new RecommendCommand("Here are some recommended triceps exercises:" + NEW_LINE
                    + "1. Close-Grip Bench Press" + NEW_LINE
                    + "2. Tricep Dips" + NEW_LINE
                    + "3. Skull Crushers");

        case "legs":
            return new RecommendCommand("Here are some recommended leg exercises:" + NEW_LINE
                    + "1. Barbell Squats" + NEW_LINE
                    + "2. Leg Extension & Leg Curls" + NEW_LINE
                    + "3. Leg Press");

        case "shoulders":
            return new RecommendCommand("Here are some recommended shoulder exercises:" + NEW_LINE
                    + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
                    + "2. Lateral Raises (Side Delt)" + NEW_LINE
                    + "3. Rear Delt Flys (Rear Delt)");

        case "abs":
            return new RecommendCommand("Here are some recommended ab exercises:" + NEW_LINE
                    + "1. Hanging Leg Raises" + NEW_LINE
                    + "2. Russian Twists" + NEW_LINE
                    + "3. Planks");

        case "forearms":
            return new RecommendCommand("Here are some recommended forearm exercises:" + NEW_LINE
                    + "1. Wrist Curls" + NEW_LINE
                    + "2. Reverse Wrist Curls" + NEW_LINE
                    + "3. Farmer's Walk");

        case "help":
            return new RecommendCommand("Here are the list of muscle groups:" + NEW_LINE
                    + "1. chest" + NEW_LINE
                    + "2. back" + NEW_LINE
                    + "3. biceps" + NEW_LINE
                    + "4. triceps" + NEW_LINE
                    + "5. legs" + NEW_LINE
                    + "6. shoulders" + NEW_LINE
                    + "7. abs" + NEW_LINE
                    + "8. forearms");

        default:
            throw new InvalidRecommendException();
        }
    }
}
