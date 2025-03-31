package seedu.healthbud.parser.addcommandparser;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.onelogandinput.AddGoalCommand;
import seedu.healthbud.exception.InvalidGoalException;
import seedu.healthbud.log.Goals;
import seedu.healthbud.parser.ParserParameters;

import java.util.Map;

public class AddGoalParser{
    static Goals goal = Goals.getInstance();

    private static String addMissingParameters(String input){
        if (!input.contains("/cal")){
            input += " /cal " +  Goals.getInstance().getDailyCalorieGoal();
        }
        if (!input.contains("/w")){
            input += " /w " + Goals.getInstance().getDailyWaterGoal();
        }
        if (!input.contains("/kg")){
            input += " /kg " + Goals.getInstance().getWeightGoal();
        }
        return input;
    }

    public static AddGoalCommand parse(LogList goalLogs, String input) throws InvalidGoalException {
        String[] parts = input.trim().split(" ");

        if (parts.length < 2) {
            throw new InvalidGoalException();
        }
        if (!input.contains("/w") && !input.contains("/cal") && !input.contains("/kg")) {
            Ui.printMessage("Welcome to goal setting! Here are your current goals: \n"
                    + Goals.getInstance().toString());
            Ui.printMessage("What goal would you like to add today?\n");
            return new AddGoalCommand(goalLogs, input, Goals.getInstance().getDailyWaterGoal(),
                    Goals.getInstance().getDailyCalorieGoal(), Goals.getInstance().getWeightGoal());
        } else {
            input = addMissingParameters(input);
            input = input.substring("add goal".length()).trim();

            Map<String, String> param = ParserParameters.parseParameters(input);

            if (!param.get("cal").matches("\\d+") || !param.get("w").matches("\\d+")
                    || !param.get("kg").matches("\\d+")) {
                throw new InvalidGoalException();
            }

            return new AddGoalCommand(goalLogs, input, param.get("w"), param.get("cal"), param.get("kg"));
        }
    }

}
