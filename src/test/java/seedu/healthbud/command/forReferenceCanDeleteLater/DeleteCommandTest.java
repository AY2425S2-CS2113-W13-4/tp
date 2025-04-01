/*
package seedu.healthbud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.healthbud.command.onelogandinput.DeleteCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidDeleteException;
import seedu.healthbud.log.Workout;
import seedu.healthbud.parser.DeleteParser;

public class DeleteCommandTest {
    private LogList workoutLogs;

    @Test
    void validPBDelete_expectSuccess() throws InvalidDeleteException, HealthBudException {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete pb 1";
        DeleteCommand command = DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);

        assertEquals(pbLogs, command.getLogList());
        assertEquals(1, command.getIndex());
    }

    @Test
    void validWaterDelete_expectSuccess() throws InvalidDeleteException, HealthBudException {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete water 3";
        DeleteCommand command = DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);

        assertEquals(waterLogs, command.getLogList());
        assertEquals(3, command.getIndex());
    }

    @Test
    void validMealDelete_expectSuccess() throws InvalidDeleteException, HealthBudException {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete meal 10";
        DeleteCommand command = DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);

        assertEquals(mealLogs, command.getLogList());
        assertEquals(10, command.getIndex());
    }

    @Test
    void validCardioDelete_expectSuccess() throws InvalidDeleteException, HealthBudException {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete cardio 3";
        DeleteCommand command = DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);

        assertEquals(cardioLogs, command.getLogList());
        assertEquals(3, command.getIndex());
    }


    @Test
    void invalidWaterDelete_nonIntegerIndex_expectThrowsInvalidDeleteException(){
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete water 1.5";
        assertThrows(HealthBudException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));

    }

    @Test
    void invalidPBDelete_nonNumericIndex_throwsHealthBudException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete PB one";
        assertThrows(HealthBudException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void invalidLogType_throwsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete invalid 1";
        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void missingIndex_throwsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete meal";
        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }

    @Test
    void missingLogType_throwsInvalidDeleteException() {
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList cardioLogs = new LogList();

        String input = "delete 1";
        assertThrows(InvalidDeleteException.class, () ->
                DeleteParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs));
    }


    @BeforeEach
    void setUp() {
        workoutLogs = new LogList();
        workoutLogs.addLog(new Workout("squats", "10", "3", "25 Dec 2023", "50"));
        workoutLogs.addLog(new Workout("bench press", "8", "4", "26 Dec 2023", "60"));
    }

    @Test
    void deleteLog_validIndex_expectSuccess() throws HealthBudException {
        assertEquals(2, workoutLogs.getSize());

        String input = "delete workout 1";
        DeleteCommand command = new DeleteCommand(workoutLogs, input, 1);
        command.execute();

        assertEquals(1, workoutLogs.getSize());
        assertEquals("bench press", ((Workout) workoutLogs.getLog(0)).getName());
    }

    @Test
    void deleteLog_indexOutOfBounds_expectThrowsHealthBudException() {
        String input = "delete workout 3";
        DeleteCommand command = new DeleteCommand(workoutLogs, input, 3);

        assertThrows(HealthBudException.class, () -> command.execute());
    }

    @Test
    void deleteLog_negativeIndex_expectThrowsHealthBudException() {
        String input = "delete workout -1";
        DeleteCommand command = new DeleteCommand(workoutLogs, input, -1);

        assertThrows(HealthBudException.class, () -> command.execute());
    }

    @Test
    void deleteLog_zeroIndex_expectThrowsHealthBudException() {
        String input = "delete workout 0";
        DeleteCommand command = new DeleteCommand(workoutLogs, input, 0);

        assertThrows(HealthBudException.class, () -> command.execute());
    }

    @Test
    void deleteLog_missingNumberInInput_expectThrowsHealthBudException() {
        String input = "delete workout";
        DeleteCommand command = new DeleteCommand(workoutLogs, input, 1);

        assertThrows(HealthBudException.class, () -> command.execute());
    }


}
*/
