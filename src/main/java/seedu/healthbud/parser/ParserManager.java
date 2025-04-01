package seedu.healthbud.parser;

import seedu.healthbud.LogList;
import seedu.healthbud.Ui;
import seedu.healthbud.command.commandinterface.Command;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.parser.addcommandparser.AddParser;

public class ParserManager {

    public static final String NEW_LINE = "\n     ";

    public static boolean handleInput(LogList goalLogs, LogList pbLogs, LogList mealLogs, LogList workoutLogs,
                                      LogList waterLogs, LogList cardioLogs, String input) throws HealthBudException {
        String[] parts = input.trim().split("\\s+");

        try {
            Command command;
            switch (parts[0]) {
            case "bye":
                return Ui.printGoodbye();
            case "add":
                String subCommand = parts[1].toLowerCase();
                command = AddParser.parse(subCommand, mealLogs, waterLogs, cardioLogs,
                        pbLogs, workoutLogs, goalLogs, input);
                break;
            case "help":
                Ui.printHelp();
                return true;
            case "list":
                command = ListParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
                break;
            case "recommend":
                command = RecommendParser.parse(input);
                break;
            case "bmi":
                command = BMIParser.parse(input);
                break;
            case "delete":
                command = DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
                break;
            case "clear":
                command = ClearParser.parse(input, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs);
                break;
            case "sum":
                command = SumParser.parse(input, mealLogs, waterLogs, cardioLogs);
                break;
            case "status":
                command = StatusParser.parse(input, goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs);
                break;
            case "search":
                command = SearchParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs, goalLogs);
                break;
            default:
                Ui.printUnknownCommand();
                return true;
            }
            command.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
