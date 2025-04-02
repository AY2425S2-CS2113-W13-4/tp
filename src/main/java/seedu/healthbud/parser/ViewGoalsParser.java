package seedu.healthbud.parser;


import seedu.healthbud.Ui;
import seedu.healthbud.log.Goals;


public class ViewGoalsParser {

    Goals goal = Goals.getInstance();
    public static void parse(String input){
        Ui.printMessage("Welcome to goal setting! Here are your current goals: \n"
                + Goals.getInstance().toString());
        Ui.printMessage("What goal would you like to add today?\n");
    }
}
