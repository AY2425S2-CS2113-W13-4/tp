package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.CommandInterface.Command;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;

public class AddParser {

    public static Command parse(String subCommand, LogList mealLogs, LogList waterLogs, LogList cardioLogs,
                                LogList pbLogs, LogList workoutLogs, String input) throws InvalidLogException,
                                InvalidCardioException, InvalidMealException, InvalidPBException, InvalidWaterException,
                                InvalidWorkoutException {

        switch (subCommand) {
        case "meal":
            return AddMealParser.parse(mealLogs, input);
        case "water":
            return AddWaterParser.parse(waterLogs, input);
        case "cardio":
            return AddCardioParser.parse(cardioLogs, input);
        case "pb":
            return AddPBParser.parse(pbLogs, input);
        case "workout":
            return AddWorkoutParser.parse(workoutLogs, input);
        default:
            throw new InvalidLogException();
        }
    }
}
