package seedu.healthbud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import seedu.healthbud.exception.InvalidMealException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import seedu.healthbud.exception.InvalidWorkoutReccException;
import seedu.healthbud.log.Meal;

class JUnitTest {

    public static final String NEW_LINE = "\n     ";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void handleMeal_correctInput_expectSuccess() throws InvalidMealException {
        LogList logs = new LogList();
        String input = "meal Chicken Rice /cal 550 /d 12-01-25 /t 9pm";

        Parser.handleMeal(logs, input);

        assertEquals(1, logs.getSize());
        assertEquals("Chicken Rice", logs.getLog(0).getName());
        assertEquals("550", ((Meal) logs.getLog(0)).getCalories());
        assertEquals("12-01-25", ((Meal) logs.getLog(0)).getDate());
        assertEquals("9pm", ((Meal) logs.getLog(0)).getTime());
    }

    @Test
    void handleMeal_wrongInput_expectFailure() throws InvalidMealException {
        LogList logs = new LogList();
        // Missing calories parameter "/cal"
        String input = "meal Chicken Rice /d 12-01-25 /t 9pm";

        assertThrows(InvalidMealException.class, () -> Parser.handleMeal(logs, input));
    }

    @Test
    void mealLog_nullInput_expectException() throws InvalidMealException {
        LogList logs = new LogList();
        String input = null;

        assertThrows(InvalidMealException.class, () -> Parser.handleMeal(logs, input));
    }

    @Test
    void handleMeal_emptyDate_expectFailure() throws InvalidMealException {
        LogList logs = new LogList();
        // The date parameter is present but empty.
        String input = "meal Chicken Rice /cal 550 /d  /t 9pm";
        assertThrows(InvalidMealException.class, () -> Parser.handleMeal(logs, input));
    }

    @Test
    void handleMeal_missingTimeParameter_expectFailure() throws InvalidMealException {
        LogList logs = new LogList();
        // Missing time parameter "/t"
        String input = "meal Chicken Rice /cal 550 /d 12-01-25";
        assertThrows(InvalidMealException.class, () -> Parser.handleMeal(logs, input));
    }

    @Test
    void handleMeal_tooManyParameters_expectFailure() throws InvalidMealException {
        LogList logs = new LogList();
        // An extra parameter "/extra" makes the split array longer than expected.
        String input = "meal Chicken Rice /cal 550 /d 12/01/25 /t 9pm /extra";
        assertThrows(InvalidMealException.class, () -> Parser.handleMeal(logs, input));
    }


    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void recommendWorkout_correctInput_expectSuccess() throws InvalidWorkoutReccException {
        setUpStreams(); // Redirect output stream

        String[][] testCases = {
                {"chest", "Here are some recommended chest exercises: " + NEW_LINE
                        + "1. Incline Smith Machine Bench Press" + NEW_LINE
                        + "2. Dumbbell Chest Press" + NEW_LINE
                        + "3. Cable Chest Flys"},
                {"back", "Here are some recommended back exercises: " + NEW_LINE
                        + "1. Pull-Ups" + NEW_LINE
                        + "2. Barbell Bent-over Rows" + NEW_LINE
                        + "3. Lat Pulldown"},
                {"biceps", "Here are some recommended biceps exercises: " + NEW_LINE
                        + "1. Barbell Bicep Curls" + NEW_LINE
                        + "2. Hammer Curls" + NEW_LINE
                        + "3. Cable Curls"},
                {"triceps", "Here are some recommended triceps exercises: " + NEW_LINE
                        + "1. Close-Grip Bench Press" + NEW_LINE
                        + "2. Tricep Dips" + NEW_LINE
                        + "3. Skull Crushers"},
                {"legs", "Here are some recommended leg exercises: " + NEW_LINE
                        + "1. Barbell Squats" + NEW_LINE
                        + "2. Leg Extension & Leg Curls" + NEW_LINE
                        + "3. Leg Press"},
                {"shoulders", "Here are some recommended shoulder exercises: " + NEW_LINE
                        + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
                        + "2. Lateral Raises (Side Delt)" + NEW_LINE
                        + "3. Rear Delt Flys (Rear Delt)"},
                {"abs", "Here are some recommended ab exercises: " + NEW_LINE
                        + "1. Hanging Leg Raises" + NEW_LINE
                        + "2. Russian Twists" + NEW_LINE
                        + "3. Planks"},
                {"forearms", "Here are some recommended forearm exercises: " + NEW_LINE
                        + "1. Wrist Curls" + NEW_LINE
                        + "2. Reverse Wrist Curls" + NEW_LINE
                        + "3. Farmer's Walk"}
        };

        for (String[] testCase : testCases) {
            outContent.reset(); // Clear previous output
            String input = "recommend /m " + testCase[0];
            Parser.recommendWorkout(input);
            System.out.flush(); // Ensure all output is captured
            assertEquals(testCase[1], outContent.toString().trim());
        }
    }
    @Test
    void recommendWorkout_missingParameters_expectFailure() throws InvalidWorkoutReccException {
        // An extra parameter "/extra" makes the array longer than expected.
        String input = "recommend biceps";
        assertThrows(InvalidWorkoutReccException.class, () -> Parser.recommendWorkout(input));
    }

    @Test
    void recommendWorkout_additionalParameters_expectFailure() throws InvalidWorkoutReccException {
        String input = "recommend /plan biceps";
        assertThrows(InvalidWorkoutReccException.class, () -> Parser.recommendWorkout(input));
    }
}

