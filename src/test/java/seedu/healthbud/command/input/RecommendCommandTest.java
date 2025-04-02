package seedu.healthbud.command.input;

import org.junit.jupiter.api.Test;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.parser.RecommendParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecommendCommandTest {

    @Test
    void recommendWorkout_chest_expectSuccess() throws Exception {
        String input = "recommend chest";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended chest exercises:\n     "
                + "1. Incline Smith Machine Bench Press\n     "
                + "2. Dumbbell Chest Press\n     "
                + "3. Cable Chest Flys";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_back_expectSuccess() throws Exception {
        String input = "recommend back";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended back exercises:\n     "
                + "1. Pull-Ups\n     "
                + "2. Barbell Bent-over Rows\n     "
                + "3. Lat Pulldown";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_triceps_expectSuccess() throws Exception {
        String input = "recommend triceps";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended triceps exercises:\n     "
                + "1. Close-Grip Bench Press\n     "
                + "2. Tricep Dips\n     "
                + "3. Skull Crushers";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_legs_expectSuccess() throws Exception {
        String input = "recommend legs";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended leg exercises:\n     "
                + "1. Barbell Squats\n     "
                + "2. Leg Extension & Leg Curls\n     "
                + "3. Leg Press";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_shoulders_expectSuccess() throws Exception {
        String input = "recommend shoulders";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended shoulder exercises:\n     "
                + "1. Overhead Dumbell Shoulder Press (Front Delt)\n     "
                + "2. Lateral Raises (Side Delt)\n     "
                + "3. Rear Delt Flys (Rear Delt)";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_abs_expectSuccess() throws Exception {
        String input = "recommend abs";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended ab exercises:\n     "
                + "1. Hanging Leg Raises\n     "
                + "2. Russian Twists\n     "
                + "3. Planks";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_forearms_expectSuccess() throws Exception {
        String input = "recommend forearms";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are some recommended forearm exercises:\n     "
                + "1. Wrist Curls\n     "
                + "2. Reverse Wrist Curls\n     "
                + "3. Farmer's Walk";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_help_expectSuccess() throws Exception {
        String input = "recommend help";
        RecommendCommand command = RecommendParser.parse(input);
        String expected = "Here are the list of muscle groups:\n     "
                + "1. chest\n     "
                + "2. back\n     "
                + "3. biceps\n     "
                + "4. triceps\n     "
                + "5. legs\n     "
                + "6. shoulders\n     "
                + "7. abs\n     "
                + "8. forearms";
        assertEquals(expected, command.getMessage());
    }

    @Test
    void recommendWorkout_invalidMuscle_expectFailure() {
        String input = "recommend toes";
        assertThrows(HealthBudException.class, () -> RecommendParser.parse(input));
    }

    @Test
    void recommendWorkout_missingInput_expectFailure() {
        String input = "recommend";
        assertThrows(InvalidRecommendException.class, () -> RecommendParser.parse(input));
    }

    @Test
    void execute_recommendCommand_printsCorrectMessage() {
        String expected = "    Test output"; // match the indent from Ui.printMessage
        RecommendCommand command = new RecommendCommand("Test output");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        command.execute();

        System.setOut(originalOut);
        assertEquals(expected + System.lineSeparator(), outContent.toString());
    }
}
