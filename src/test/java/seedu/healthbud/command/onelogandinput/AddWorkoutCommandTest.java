package seedu.healthbud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.healthbud.command.onelogandinput.AddWorkoutCommand;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Workout;
import seedu.healthbud.parser.addcommandparser.AddWorkoutParser;

//@@author Travissssz
public class AddWorkoutCommandTest {

    // ========== **SUCCESS CASES (VALID INPUTS)** ==========
    @Test
    void parse_validInput_createsCorrectCommand() throws Exception {
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
    void parse_inputWithDifferentParameterOrder_works() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /w 50 /d 25-12-2023 /s 3 /r 10";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        assertEquals("10", command.getReps()); // Ensures parsing works regardless of order
    }

    @Test
    void parse_zeroValues_acceptsInput() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 0 /s 0 /d 25-12-2023 /w 0";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        assertEquals("0", command.getReps()); // Tests zero-value handling
    }

    @Test
    void execute_validWorkout_addsToLogList() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w 50";
        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        command.execute();

        Workout addedWorkout = (Workout) workoutLogs.getLog(0);
        assertEquals("squats", addedWorkout.getName()); // Ensures execute() works
    }

    // ========== **FAILURE CASES (INVALID INPUTS)** ==========
    @Test
    void parse_missingName_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_missingReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_missingSets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_missingDate_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_missingWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_nonNumericReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r ten /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_nonNumericSets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s three /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_nonNumericWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w fifty";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_negativeReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r -10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyInput_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_invalidDateFormat_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 12/25 /w 50";

        assertThrows(InvalidDateFormatException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    // ========== **EDGE CASES (EXTREME VALUES)** ==========
    @Test
    void parse_maxIntegerValues_works() throws Exception {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 2147483647 /s 2147483647 /d 25-12-2023 /w 2147483647";

        AddWorkoutCommand command = AddWorkoutParser.parse(workoutLogs, input);

        assertEquals("2147483647", command.getReps()); // Tests max int handling
    }


    // ========== **WORKOUT CLASS TESTS** ==========
    @Test
    void workoutToString_returnsCorrectFormat() {
        Workout workout = new Workout("squats", "10", "3", "25 Dec 2023", "50");
        String expected = "squats (3 sets of 50 kg for 10 reps) on 25 Dec 2023";

        assertEquals(expected, workout.toString()); // Ensures toString() works
    }

    @Test
    void parse_emptyRepsValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptySetsValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyDateValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_emptyWeightValue_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyName_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout    /r 10 /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyReps_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r    /s 3 /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlySets_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s    /d 25-12-2023 /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyDate_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d    /w 50";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

    @Test
    void parse_whitespaceOnlyWeight_throwsException() {
        LogList workoutLogs = new LogList();
        String input = "add workout squats /r 10 /s 3 /d 25-12-2023 /w    ";

        assertThrows(InvalidWorkoutException.class, () ->
                AddWorkoutParser.parse(workoutLogs, input));
    }

}
