package seedu.healthbud.parser;

import org.junit.jupiter.api.Test;

import seedu.healthbud.LogList;
import seedu.healthbud.command.singlelog.AddCardioCommand;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.parser.addcommandparser.AddCardioParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCardioCommandTest {

    @Test
    void parse_validInputWithAllParameters_success() throws InvalidCardioException, InvalidDateFormatException {
        String input = "add cardio Running /s 8.5 /i 5 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        AddCardioCommand command = AddCardioParser.parse(cardioLogs, input);

        assertNotNull(command);
        assertEquals("Running", command.getName());
        assertEquals("8.5", command.getSets());
        assertEquals("5", command.getIntensity());
        assertEquals("30", command.getTime());
        assertEquals("25 Dec 2023", command.getDate());
    }

    @Test
    void parse_validInputWithDifferentDateFormat_success()
            throws InvalidCardioException, InvalidDateFormatException {
        String input = "add cardio Cycling /s 10 /i 3 /t 45 /d 25/12/2023";
        LogList cardioLogs = new LogList();

        AddCardioCommand command = AddCardioParser.parse(cardioLogs, input);

        assertNotNull(command);
        assertEquals("Cycling", command.getName());
        assertEquals("25 Dec 2023", command.getDate());
    }

    @Test
    void parse_validInputWithSpacesInName_success()
            throws InvalidCardioException, InvalidDateFormatException {
        String input = "add cardio Morning Jog /s 6 /i 4 /t 20 /d Dec 25, 2023";
        LogList cardioLogs = new LogList();

        AddCardioCommand command = AddCardioParser.parse(cardioLogs, input);

        assertNotNull(command);
        assertEquals("Morning Jog", command.getName());
        assertEquals("25 Dec 2023", command.getDate());
    }

    @Test
    void parse_missingName_throwsInvalidCardioException() {
        String input = "add cardio /s 8 /i 5 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_missingSpeedParameter_throwsInvalidCardioException() {
        String input = "add cardio Running /i 5 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_missingInclineParameter_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_missingDurationParameter_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i 5 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_missingDateParameter_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i 5 /t 30";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_emptySpeedValue_throwsInvalidCardioException() {
        String input = "add cardio Running /s /i 5 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_emptyInclineValue_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_emptyDurationValue_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i 5 /t /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_emptyDateValue_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i 5 /t 30 /d";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_nonNumericSpeed_throwsInvalidCardioException() {
        String input = "add cardio Running /s abc /i 5 /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_nonNumericIncline_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i abc /t 30 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_nonNumericDuration_throwsInvalidCardioException() {
        String input = "add cardio Running /s 8 /i 5 /t abc /d 2023-12-25";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_emptyInput_throwsInvalidCardioException() {
        String input = "";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_whitespaceInput_throwsInvalidCardioException() {
        String input = "   ";
        LogList cardioLogs = new LogList();

        assertThrows(InvalidCardioException.class, () -> AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void parse_parametersInDifferentOrder_success()
            throws InvalidCardioException, InvalidDateFormatException {
        String input = "add cardio Rowing /d 2023-12-25 /t 20 /s 7 /i 3";
        LogList cardioLogs = new LogList();

        AddCardioCommand command = AddCardioParser.parse(cardioLogs, input);

        assertNotNull(command);
        assertEquals("Rowing", command.getName());
        assertEquals("7", command.getSets());
        assertEquals("3", command.getIntensity());
        assertEquals("20", command.getTime());
        assertEquals("25 Dec 2023", command.getDate());
    }

    @Test
    void parse_decimalValues_success()
            throws InvalidCardioException, InvalidDateFormatException {
        String input = "add cardio Elliptical /s 6.5 /i 4.2 /t 32.5 /d 2023-12-25";
        LogList cardioLogs = new LogList();

        AddCardioCommand command = AddCardioParser.parse(cardioLogs, input);

        assertNotNull(command);
        assertEquals("6.5", command.getSets());
        assertEquals("4.2", command.getIntensity());
        assertEquals("32.5", command.getTime());
    }

    @Test
    void validCardioAddsToLogList_exepectSuccess() throws InvalidCardioException {
        LogList cardioLogs = new LogList();
        String input = "add cardio Running /s 8 /i 5 /t 90 /d 2023-12-25";

        AddCardioCommand command = new AddCardioCommand(cardioLogs, input, "running", "8", "5", "90", "12 Jan 2025");

        command.execute();

        Cardio cardio = (Cardio) cardioLogs.getLog(0);
        assertEquals("running", cardio.getName());
        assertEquals("8", command.getSets());
        assertEquals("5", command.getIntensity());
        assertEquals("90", command.getTime());
        assertEquals("12 Jan 2025", command.getDate());

        String expected = "running (speed: 8, incline: 5, duration: 90 mins) on 12 Jan 2025";

        assertEquals(expected, cardio.toString());
    }

    @Test
    void validCardioToStringReturnsCorrectString_expectSuccess() {
        LogList cardioLogs = new LogList();
        String input = "add cardio running /s 8.5 /i 2 /t 30 /d 25-12-2023";
        AddCardioCommand command = new AddCardioCommand(
                cardioLogs, input, "running", "8.5", "2", "30", "25 Dec 2023");

        String expected = "running (speed: 8.5, incline: 2, duration: 30 mins) on 25 Dec 2023";
        Cardio cardio = new Cardio("running", "8.5", "2", "30", "25 Dec 2023");

        assertEquals(expected, cardio.toString());
    }
}

