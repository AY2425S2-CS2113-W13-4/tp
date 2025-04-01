package seedu.healthbud.command.alllogsandinput;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.command.onelogandinput.AddMealCommand;
import seedu.healthbud.command.onelogandinput.AddCardioCommand;
import seedu.healthbud.exception.InvalidStatusException;
import seedu.healthbud.parser.StatusParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StatusCommandTest {

    private String getCommandOutput(StatusCommand command) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        command.execute();

        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    void statusChange_validCutting_expectSuccess() throws InvalidStatusException {
        LogList empty = new LogList();
        String input = "status change cutting";
        StatusCommand command = StatusParser.parse(input, empty, empty, empty, empty, empty, empty);
        assertEquals("Status updated to: cutting", getCommandOutput(command));
    }

    @Test
    void statusChange_validBulking_expectSuccess() throws InvalidStatusException {
        LogList empty = new LogList();
        String input = "status change bulking";
        StatusCommand command = StatusParser.parse(input, empty, empty, empty, empty, empty, empty);
        assertEquals("Status updated to: bulking", getCommandOutput(command));
    }

    @Test
    void statusChange_invalidKeyword_expectException() {
        LogList empty = new LogList();
        String input = "status change shreeding";
        assertThrows(InvalidStatusException.class, () ->
                StatusParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void statusChange_missingArgument_expectException() {
        LogList empty = new LogList();
        String input = "status change";
        assertThrows(InvalidStatusException.class, () ->
                StatusParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void statusReport_bulkingNotOnTrack_expectMessage() throws InvalidStatusException {
        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList cardio = new LogList();

        StatusParser.parse("status change bulking", empty, empty, meal, empty, empty, cardio);

        new AddMealCommand(meal, "", "Lunch", "300",
                "2024-04-01", "12:00").execute();
        new AddCardioCommand(cardio, "", "Stairs", "4",
                "1", "30", "2024-04-01").execute();

        StatusCommand command = StatusParser.parse("status report 2024-04-01", empty,
                empty, meal, empty, empty, cardio);
        String expected = "Current Status: bulking\nYour intake does not align with your goal. Net calories: -350";
        assertEquals(expected, getCommandOutput(command));
    }

    @Test
    void statusReport_bulkingOnTrack_expectSuccess() throws InvalidStatusException {
        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList cardio = new LogList();

        StatusParser.parse("status change bulking", empty, empty, meal, empty, empty, cardio);

        new AddMealCommand(meal, "", "Lunch", "300", "2024-04-01", "12:00").execute();
        new AddCardioCommand(cardio, "", "Jog", "1", "0",
                "30", "2024-04-01").execute();

        StatusCommand command = StatusParser.parse("status report 2024-04-01", empty, empty, meal,
                empty, empty, cardio);
        String expected = "Current Status: bulking\nYou are on track for bulking! Net calories: 200";
        assertEquals(expected, getCommandOutput(command));
    }


    @Test
    void statusReport_cuttingNotOnTrack_expectMessage() throws InvalidStatusException {
        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList cardio = new LogList();

        StatusParser.parse("status change cutting", empty, empty, meal, empty, empty, cardio);

        new AddMealCommand(meal, "", "Dinner", "300", "2024-04-01", "18:00").execute();
        new AddCardioCommand(cardio, "", "Jog", "1", "0",
                "30", "2024-04-01").execute();

        StatusCommand command = StatusParser.parse("status report 2024-04-01", empty, empty,
                meal, empty, empty, cardio);
        String expected = "Current Status: cutting\nYour intake does not align with your goal. Net calories: 200";
        assertEquals(expected, getCommandOutput(command));
    }

    @Test
    void statusReport_cuttingOnTrack_expectSuccess() throws InvalidStatusException {
        LogList empty = new LogList();
        LogList meal = new LogList();
        LogList cardio = new LogList();

        StatusParser.parse("status change cutting", empty, empty, meal, empty, empty, cardio);

        new AddMealCommand(meal, "", "Oats", "200", "2024-04-01", "08:00").execute();
        new AddCardioCommand(cardio, "", "HIIT", "3", "0",
                "30", "2024-04-01").execute();

        StatusCommand command = StatusParser.parse("status report 2024-04-01", empty, empty,
                meal, empty, empty, cardio);
        String expected = "Current Status: cutting\nYou are on track for cutting! Net calories: -100";
        assertEquals(expected, getCommandOutput(command));
    }

    @Test
    void statusReport_missingDate_expectException() {
        LogList empty = new LogList();
        String input = "status report";
        assertThrows(InvalidStatusException.class, () ->
                StatusParser.parse(input, empty, empty, empty, empty, empty, empty));
    }

    @Test
    void statusReport_invalidAction_expectException() {
        LogList empty = new LogList();
        String input = "status update";

        assertThrows(InvalidStatusException.class, () ->
                StatusParser.parse(input, empty, empty, empty, empty, empty, empty));
    }
}
