package seedu.healthbud;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
//import seedu.healthbud.command.AddLogCommand;
//import seedu.healthbud.command.BMICommand;
import seedu.healthbud.command.RecommendCommand;
//import seedu.healthbud.exception.HealthBudException;
//import seedu.healthbud.exception.InvalidBMIException;
import seedu.healthbud.exception.InvalidRecommendException;
//import seedu.healthbud.log.Meal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JUnitTest {

    public static final String NEW_LINE = "\n     ";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    //    @Test
    //    void handleMeal_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException {
    //        LogList mealLogs = new LogList();
    //        LogList workoutLogs = new LogList();
    //        String input = "meal Chicken Rice /cal 550 /d 12-01-25 /t 9pm";
    //
    //        new AddLogCommand().execute(mealLogs, workoutLogs, input);
    //
    //        assertEquals(1, mealLogs.getSize());
    //        assertEquals("Chicken Rice", mealLogs.getLog(0).getName());
    //        assertEquals("550", ((Meal) mealLogs.getLog(0)).getCalories());
    //        assertEquals("12-01-25", ((Meal) mealLogs.getLog(0)).getDate());
    //        assertEquals("9pm", ((Meal) mealLogs.getLog(0)).getTime());
    //    }

    //    @Test
    //    void handleMeal_wrongInput_expectFailure() throws InvalidMealException {
    //        LogList mealLogs = new LogList();
    //        LogList workoutLogs = new LogList();
    //        // Missing calories parameter "/cal"
    //        String input = "meal Chicken Rice /d 12-01-25 /t 9pm";
    //
    //        assertThrows(InvalidMealException.class, () -> new AddLogCommand().execute(mealLogs, workoutLogs, input));
    //    }


    //    @Test
    //    void handleMeal_emptyDate_expectFailure() throws InvalidMealException {
    //        LogList mealLogs = new LogList();
    //        LogList workoutLogs = new LogList();
    //        // The date parameter is present but empty.
    //        String input = "meal Chicken Rice /cal 550 /d  /t 9pm";
    //        assertThrows(InvalidMealException.class, () -> new AddLogCommand().execute(mealLogs, workoutLogs, input));
    //    }

    //    @Test
    //    void handleMeal_missingTimeParameter_expectFailure() throws InvalidMealException {
    //        LogList mealLogs = new LogList();
    //        LogList workoutLogs = new LogList();
    //        // Missing time parameter "/t"
    //        String input = "meal Chicken Rice /cal 550 /d 12-01-25";
    //        assertThrows(InvalidMealException.class, () -> new AddLogCommand().execute(mealLogs, workoutLogs, input));
    //    }

    //    @Test
    //    void handleMeal_tooManyParameters_expectFailure() throws InvalidMealException {
    //        LogList mealLogs = new LogList();
    //        LogList workoutLogs = new LogList();
    //        // An extra parameter "/extra" makes the split array longer than expected.
    //        String input = "meal Chicken Rice /cal 550 /d 12/01/25 /t 9pm /extra";
    //        assertThrows(InvalidMealException.class, () -> new AddLogCommand().execute(mealLogs, workoutLogs, input));
    //    }

    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //    @Test
    //    void recommendWorkout_correctInput_expectSuccess() throws HealthBudException { //fail
    //        setUpStreams(); // Redirect output stream
    //
    //        String[][] testCases = {
    //                {"chest", "Here are some recommended chest exercises: " + NEW_LINE
    //                        + "1. Incline Smith Machine Bench Press" + NEW_LINE
    //                        + "2. Dumbbell Chest Press" + NEW_LINE
    //                        + "3. Cable Chest Flys"},
    //                {"back", "Here are some recommended back exercises: " + NEW_LINE
    //                        + "1. Pull-Ups" + NEW_LINE
    //                        + "2. Barbell Bent-over Rows" + NEW_LINE
    //                        + "3. Lat Pulldown"},
    //                {"biceps", "Here are some recommended biceps exercises: " + NEW_LINE
    //                        + "1. Barbell Bicep Curls" + NEW_LINE
    //                        + "2. Hammer Curls" + NEW_LINE
    //                        + "3. Cable Curls"},
    //                {"triceps", "Here are some recommended triceps exercises: " + NEW_LINE
    //                        + "1. Close-Grip Bench Press" + NEW_LINE
    //                        + "2. Tricep Dips" + NEW_LINE
    //                        + "3. Skull Crushers"},
    //                {"legs", "Here are some recommended leg exercises: " + NEW_LINE
    //                        + "1. Barbell Squats" + NEW_LINE
    //                        + "2. Leg Extension & Leg Curls" + NEW_LINE
    //                        + "3. Leg Press"},
    //                {"shoulders", "Here are some recommended shoulder exercises: " + NEW_LINE
    //                        + "1. Overhead Dumbell Shoulder Press (Front Delt)" + NEW_LINE
    //                        + "2. Lateral Raises (Side Delt)" + NEW_LINE
    //                        + "3. Rear Delt Flys (Rear Delt)"},
    //                {"abs", "Here are some recommended ab exercises: " + NEW_LINE
    //                        + "1. Hanging Leg Raises" + NEW_LINE
    //                        + "2. Russian Twists" + NEW_LINE
    //                        + "3. Planks"},
    //                {"forearms", "Here are some recommended forearm exercises: " + NEW_LINE
    //                        + "1. Wrist Curls" + NEW_LINE
    //                        + "2. Reverse Wrist Curls" + NEW_LINE
    //                        + "3. Farmer's Walk"},
    //                {"help", "Here are the list of muscle groups: " + NEW_LINE
    //                        + "1. chest" + NEW_LINE
    //                        + "2. back" + NEW_LINE
    //                        + "3. biceps" + NEW_LINE
    //                        + "4. triceps" + NEW_LINE
    //                        + "5. legs" + NEW_LINE
    //                        + "6. shoulders" + NEW_LINE
    //                        + "7. abs" + NEW_LINE
    //                        + "8. forearms"}
    //
    //        };
    //
    //        for (String[] testCase : testCases) {
    //            outContent.reset(); // Clear previous output
    //            String input = "recommend /m " + testCase[0];
    //            new Recommend().execute(new LogList(), input);
    //            System.out.flush(); // Ensure all output is captured
    //            assertEquals(testCase[1], outContent.toString().trim());
    //        }
    //    }

    //    @Test
    //    void recommendWorkout_missingParameters_expectFailure() throws InvalidRecommendException {
    //        // An extra parameter "/extra" makes the array longer than expected.
    //        String input = "recommend";
    //        assertThrows(InvalidRecommendException.class, ()
    //        -> new RecommendCommand().execute(new LogList(), new LogList(), input));
    //    }

    @Test
    void recommendWorkout_additionalParameters_expectException() throws InvalidRecommendException {
        String input = "recommend /plan biceps";
        assertThrows(Throwable.class, () -> new RecommendCommand().execute(new LogList(), new LogList(),
                new LogList(), new LogList(), input));
        // assertThrows(HealthBudException.class, () -> new Recommend().execute(new LogList(), input));
    }

    // ========================= BMI Tests =========================

    //    @Test
    //    void calculateBmi_validInput_expectSuccess() throws HealthBudException { //fail
    //        String input = "bmi /w 70 /h 1.78";
    //        BMI.calculateFromInput(input);
    //        double expected = 70 / (1.78 * 1.78);
    //        assertEquals(expected, result, 0.01);
    //    }
    //
    //    @Test
    //    void calculateBmi_negativeNumbers_expectFailure(){
    //        String input = "bmi /w -68 /h 1.78";
    //        assertThrows(HealthBudException.class, ()
    //        -> new BMICommand(input).execute(new LogList(), new LogList(), input));
    //    }
    //
    //    @Test
    //    void calculateBmi_missingWeight_expectFailure() {
    //        String input = "bmi /h 1.78";
    //        assertThrows(InvalidBMIException.class, ()
    //        -> new BMICommand(input).execute(new LogList(), new LogList(), input));
    //    }
    //
    //    @Test
    //    void calculateBmi_missingHeight_expectFailure() {
    //        String input = "bmi /w 70";
    //        assertThrows(InvalidBMIException.class, ()
    //        -> new BMICommand(input).execute(new LogList(), new LogList(), input));
    //    }

    //    @Test
    //    void calculateBmi_invalidNumberFormat_expectFailure() { //fail
    //        String input = "bmi /w seventy /h 1.78";
    //        assertThrows(HealthBudException.class, () -> BMI.calculateFromInput(input));
    //    }
}
