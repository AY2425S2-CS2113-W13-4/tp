/*
package seedu.healthbud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.healthbud.command.onelogandinput.AddWorkoutCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Workout;
import seedu.healthbud.parser.addcommandparser.AddWorkoutParser;

public class AddWorkoutCommandTest {

    @Test
    void addWorkout_correctInput_expectSuccess()
            throws InvalidDateFormatException, InvalidWorkoutException {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        assertEquals("squats", command.getName());
        assertEquals("10", command.getReps());
        assertEquals("3", command.getSets());
        assertEquals("25 Dec 2023", command.getDate());
        assertEquals("50", command.getWeight());
    }

    @Test
    void addWorkout_missingReps_expectFailure() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void addWorkout_missingName_expectFailure() {
        LogList workoutLogs = new LogList();
        String input = "add workout /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void addWorkout_decimalSets_expectFailure() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3.5 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }


    @Test
    void addWorkout_invalidDateFormat_expectFailure() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-Dec-2023 /w 50";

        assertThrows(InvalidDateFormatException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void addWorkout_nonNumericSet_expectThrowsInvalidCardioException() {
        LogList WorkoutLogs = new LogList();
        String input = "add workout squats /r 10 /s three /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(WorkoutLogs, input));
    }

    @Test
    void addCardio_emptyInput_expectThrowsInvalidCardioException() {
        LogList WorkoutLogs = new LogList();
        String input = "add workout";


        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(WorkoutLogs, input));
    }


    @Test
    void validWorkout_addsToLogList_expectSuccess() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50";
        AddWorkoutCommand command = new AddWorkoutCommand(
                workoutLogs, input, "squats", "10", "3", "25 Dec 2023", "50");

        command.execute();

        Workout addedWorkout = (Workout) workoutLogs.getLog(0);
        assertEquals("squats", addedWorkout.getName());
        assertEquals("10", addedWorkout.getReps());
        assertEquals("3", addedWorkout.getSets());
        assertEquals("25 Dec 2023", addedWorkout.getDate());
        assertEquals("50", addedWorkout.getWeight());
    }

    @Test
    void validWorkout_returnsCorrectString_expectSuccess() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50";
        AddWorkoutCommand command = new AddWorkoutCommand(
                workoutLogs, input, "squats", "10", "3", "25 Dec 2023", "50");

        String expected = "squats (3 sets of 50 kg for 10 reps) on 25 Dec 2023";
        Workout workout = new Workout("squats", "10", "3", "25 Dec 2023", "50");

        assertEquals(expected, workout.toString());
    }


}
*/
