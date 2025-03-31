package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.command.commandinterface.Command;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.exception.InvalidLogException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPBException;
import seedu.healthbud.exception.InvalidWaterException;
import seedu.healthbud.exception.InvalidWorkoutException;

public class AddParser {

    public static Command parse(String subCommand, LogList mealLogs, LogList waterLogs, LogList cardioLogs,
                                LogList pbLogs, LogList workoutLogs, LogList goalLogs, String input) throws
                                InvalidLogException,
                                InvalidCardioException, InvalidMealException, InvalidPBException, InvalidWaterException,
                                InvalidWorkoutException, InvalidDateFormatException, InvalidGoalException {

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
        case "goal":
            return AddGoalParser.parse(goalLogs, input);
        default:
            throw new InvalidLogException();
        }
    }
}
