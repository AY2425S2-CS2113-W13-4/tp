package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidDeleteException;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.parser.DeleteParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteCommandTest {

    @Test
    void deleteMeal_correctInput_expectSuccess() throws InvalidPersonalBestException, InvalidMLException,
            InvalidCardioException, HealthBudException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-25 /t 9pm";

        AddMealCommand addCommand = new AddMealCommand(mealLogs, input, "chicken rice", "550", "12 Jan 2025", "9pm");
        addCommand.execute();
        assertEquals(1, mealLogs.getSize());

        String deleteInput = "delete meal 1";
        DeleteCommand deleteCommand = new DeleteCommand(mealLogs, deleteInput, 1);
        deleteCommand.execute();

        String expected = "Noted. I've removed this log:";
        assertTrue(output.toString().contains(expected));

        assertEquals(0, mealLogs.getSize());
    }

    @Test
    void deleteMeal_wrongInput_expectFailure() {

        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete meal"; // missing index

        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void deleteParser_nonNumericIndex_expectThrowsHealthBudException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        // Non-numeric index provided
        String input = "delete meal one";

        HealthBudException exception = assertThrows(HealthBudException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
        assertEquals("Insert a valid task number", exception.getMessage());
    }

    @Test
    void deleteParser_invalidLogType_expectThrowsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete unknown 1";

        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    
}


