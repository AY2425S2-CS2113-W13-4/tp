package seedu.healthbud.command.multilog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddMealCommand;
import seedu.healthbud.command.singlelog.AddWaterCommand;
import seedu.healthbud.exception.InvalidTrackException;
import seedu.healthbud.parser.TrackGoalParser;
import seedu.healthbud.parser.ViewGoalsParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrackGoalCommandTest {

    private String getCommandOutput(TrackGoalCommand command) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        command.execute();

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    void trackGoal_validDate_expectCorrectOutput() throws Exception {
        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList water = new LogList();

        new AddMealCommand(meal,"Lunch", "300", "01/04/2024", "13:00").execute();
        new AddWaterCommand(water, "500", "01/04/2024", "13:10").execute();

        TrackGoalCommand command = new TrackGoalCommand("01/04/2024", empty, empty, meal, empty, water, empty);
        String output = getCommandOutput(command);
        String expected = "Here is your goal progress for 01 Apr 2024: ";
        assertEquals(expected, output.split("\n")[0]);
    }

    @Test
    void parse_validCommand_expectCorrectOutput() throws Exception {
        String input = "track goal /d 01/04/2024";

        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList water = new LogList();

        new AddMealCommand(meal,"Lunch", "300", "01/04/2024", "13:00").execute();
        new AddWaterCommand(water,"500", "01/04/2024", "13:10").execute();

        TrackGoalCommand command = TrackGoalParser.parse(input, empty, empty, meal, empty, water, empty);
        String output = getCommandOutput(command);
        String expected = "Here is your goal progress for 01 Apr 2024: ";
        assertEquals(expected, output.split("\n")[0]);
    }

    @Test
    void parse_missingDateArgument_expectException() {
        String input = "track goal";
        LogList empty = new LogList();

        assertThrows(InvalidTrackException.class, () ->
                TrackGoalParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void parse_invalidSlash_expectException() {
        String input = "track goal /date 2024-04-01";
        LogList empty = new LogList();

        assertThrows(InvalidTrackException.class, () ->
                TrackGoalParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void parse_missingSlash_expectException() {
        String input = "track goal 2024-04-01"; // 3 tokens, still fails !parts[2].equals("/d")
        LogList empty = new LogList();

        assertThrows(InvalidTrackException.class, () ->
                TrackGoalParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void constructor_nullDate_throwsAssertionError() {
        LogList empty = new LogList();
        assertThrows(AssertionError.class, () ->
                new TrackGoalCommand(null, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void parser_nullInput_throwsAssertionError() {
        LogList empty = new LogList();
        assertThrows(AssertionError.class, () ->
                TrackGoalParser.parse(null, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void constructor_emptyDate_throwsAssertionError() {
        LogList empty = new LogList();
        assertThrows(AssertionError.class, () ->
                new TrackGoalCommand("   ", empty, empty, empty, empty, empty, empty));
    }
    @Test
    void trackGoalConstructor_nullDate_throwsAssertionError() {
        LogList empty = new LogList();
        assertThrows(AssertionError.class, () ->
                new TrackGoalCommand(null, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void viewGoalsParser_validInput_printsGoalMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ViewGoalsParser.parse("view goal");

        System.setOut(originalOut);
        String output = outContent.toString().trim();

        assertTrue(output.contains("Welcome to goal setting! Here are your current goals:"),
                "Should print welcome message with current goals");
        assertTrue(output.contains("What goal would you like to add today?"),
                "Should prompt the user to add a goal");
    }

    @Test
    void viewGoalsParser_nullInput_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> ViewGoalsParser.parse(null));
    }


}
