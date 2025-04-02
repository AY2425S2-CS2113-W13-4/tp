package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.parser.addcommandparser.AddCardioParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//import static org.junit.jupiter.api.Assertions.*;

class AddCardioCommandTest {
    @Test
    void addCardio_correctInput_expectSuccess()
            throws InvalidDateFormatException {

        LogList cardioLogs = new LogList();
        String input = "add cardio running /s 8.5 /i 2 /t 30 /d 25-12-2023";

        AddCardioCommand command = AddCardioParser.parse(cardioLogs,input);

        assertEquals("running", command.getName());
        assertEquals("8.5", command.getSets());
        assertEquals("2", command.getIntensity());
        assertEquals("25 Dec 2023", command.getDate());
        assertEquals("30", command.getTime());
    }

    @Test
    void addCardio_missingName_expectThrowsInvalidCardioException() {
        LogList cardioLogs = new LogList();
        String input = "add cardio /s 8.5 /i 2 /t 30 /d 25-12-2023";

        assertThrows(InvalidCardioException.class, () ->
                AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void addCardio_missingSpeedParameter_expectThrowsInvalidCardioException() {
        LogList cardioLogs = new LogList();
        String input = "add cardio running /i 2 /t 30 /d 25-12-2023";

        assertThrows(InvalidCardioException.class, () ->
                AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void addCardio_nonNumericSpeed_expectThrowsInvalidCardioException() {
        LogList cardioLogs = new LogList();
        String input = "add cardio running /s fast /i 2 /t 30 /d 25-12-2023";

        assertThrows(InvalidCardioException.class, () ->
                AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void addCardio_emptyInput_expectThrowsInvalidCardioException() {
        LogList cardioLogs = new LogList();
        String input = "add cardio";

        assertThrows(InvalidCardioException.class, () ->
                AddCardioParser.parse(cardioLogs, input));
    }

    @Test
    void validCardioAddsToLogList_expectSuccess() {
        LogList cardioLogs = new LogList();
        String input = "add cardio running /s 8.5 /i 2 /t 30 /d 25-12-2023";
        AddCardioCommand command = new AddCardioCommand(
                cardioLogs, input, "running", "8.5", "2", "30", "25 Dec 2023");

        command.execute();

        Cardio addedCardio = (Cardio) cardioLogs.getLog(0);
        assertEquals("running", addedCardio.getName());
        assertEquals("8.5", addedCardio.getSpeed());
        assertEquals("2", addedCardio.getIncline());
        assertEquals("30", addedCardio.getDuration());
        assertEquals("25 Dec 2023", addedCardio.getDate());
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
