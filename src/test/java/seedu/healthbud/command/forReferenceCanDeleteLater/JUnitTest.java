/*
package seedu.healthbud;

//import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import seedu.healthbud.command.inputonly.RecommendCommand;
import seedu.healthbud.command.inputonly.BMICommand;

import seedu.healthbud.command.onelogandinput.ListCommand;
import seedu.healthbud.exception.HealthBudException;
import seedu.healthbud.exception.InvalidRecommendException;
import seedu.healthbud.exception.InvalidBMIException;


import seedu.healthbud.parser.RecommendParser;
import seedu.healthbud.parser.BMIParser;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class JUnitTest {

    //        ========================= Recommend Tests =========================
    @Test
    void recommendWorkout_correctInput_expectSuccess() throws InvalidRecommendException, HealthBudException {
        String input = "recommend biceps";
        RecommendCommand command = RecommendParser.parse(input);

        String expected = "Here are some recommended biceps exercises:\n     "
                + "1. Barbell Bicep Curls\n     "
                + "2. Hammer Curls\n     "
                + "3. Cable Curls";

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


    //        ========================= BMI Tests =========================
    @Test
    void parse_validInput_expectSuccess() throws HealthBudException, InvalidBMIException {
        String input = "bmi /w 70 /h 1.75";
        BMICommand command = BMIParser.parse(input);
        assertNotNull(command, "BMICommand should not be null for valid input");
    }

    @Test
    void parse_withoutHeightOrWeight_expectInvalidBmiException() {
        String input = "bmi";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(input));
    }

    @Test
    void parse_tooFewParts_expectInvalidBmiException() {
        String input = "bmi 70 /h";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(input));
    }

    @Test
    void parse_invalidNumberFormat_expectInvalidBmiException() {
        String input = "bmi seventy /h 1.75";
        assertThrows(InvalidBMIException.class, () -> BMIParser.parse(input));
    }
    //        ========================= ListTests =========================
    @Test
    void listCommand_creation_notNull() {
        LogList mealLogs;
        mealLogs = new LogList();
        // Basic test to ensure the command is created properly
        ListCommand listCommand = new ListCommand("list meal", mealLogs);
        assertNotNull(listCommand, "ListCommand object should not be null after creation.");
    }

    // ================================================================= till here

























    //        ========================= Water Log Tests =========================
    @Test
    void waterLog_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add water /ml 1000 /d 12-01-25 /t 8am";

        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        assertEquals(1, waterLogs.getSize());
        assertEquals("1000", ((Water) waterLogs.getLog(0)).getAmount());
        assertEquals("12-01-25", (waterLogs.getLog(0)).getDate());
        assertEquals("8am", ((Water) waterLogs.getLog(0)).getTime());
    }

    @Test
    void waterLog_wrongInput_expectFailure() {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add water /ml 500 /d 12-01-25"; // missing /t

        assertThrows(InvalidWaterException.class, () -> new AddLogCommand().execute(
                goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input));
    }

    //        ========================= Workout Log Tests =========================
    @Test
    void workoutLog_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add workout Pushups /r 20 /s 3 /d 12-01-25";

        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        assertEquals(1, workoutLogs.getSize());
        assertEquals("Pushups", ((WorkOUT) workoutLogs.getLog(0)).getName());
        assertEquals("20", ((WorkOUT) workoutLogs.getLog(0)).getReps());
        assertEquals("3", ((WorkOUT) workoutLogs.getLog(0)).getSets());
        assertEquals("12-01-25", (workoutLogs.getLog(0)).getDate());
    }

    @Test
    void workoutLog_wrongInput_expectFailure() {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add workout Pushups /r 20 /d 12-01-25"; // missing /s sets

        assertThrows(InvalidWorkoutException.class, () -> new AddLogCommand().execute(
                goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input));
    }

    //        ========================= Cardio Log Tests =========================
    @Test
    void cardioLog_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add cardio treadmill /s 6 /i 2 /t 20 /d 12-01-25";

        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        assertEquals(1, cardioLogs.getSize());
        assertEquals("treadmill", ((Cardio) cardioLogs.getLog(0)).getName());
        assertEquals("6", ((Cardio) cardioLogs.getLog(0)).getSpeed());
        assertEquals("2", ((Cardio) cardioLogs.getLog(0)).getIncline());
        assertEquals("20", ((Cardio) cardioLogs.getLog(0)).getDuration());
        assertEquals("12-01-25", (cardioLogs.getLog(0)).getDate());
    }

    @Test
    void cardioLog_wrongInput_expectFailure() {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "add cardio treadmill /s 6 /i 2 /d 12-01-25"; // missing /t

        assertThrows(InvalidCardioException.class, () -> new AddLogCommand().execute(
                goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input));
    }

    //        ========================= PB Log Tests =========================


    //        ========================= Recommend Tests =========================
    @Test
    void recommendWorkout_correctInput_expectSuccess() throws InvalidRecommendException, HealthBudException{
        RecommendCommand command = new RecommendCommand();
        String input = "recommend biceps";

        String expected = "Here are some recommended biceps exercises:\n     "
                + "1. Barbell Bicep Curls\n     "
                + "2. Hammer Curls\n     "
                + "3. Cable Curls";

        assertEquals(expected, command.getRecommendation(input));
    }

    @Test
    void recommendWorkout_wrongInput_expectFailure(){
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "recommend";
        assertThrows(InvalidRecommendException.class, () -> new RecommendCommand().execute(goalLogs, pbLogs, mealLogs,
                workoutLogs, waterLogs, cardioLogs,  input));
    }

    // ========================= BMI Tests =========================

    @Test
    void calculateBmi_validInput_expectSuccess() throws Exception {
        // Capture printed output.
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "bmi /w 70 /h 1.78";
        BMICommand command = new BMICommand(input);
        command.execute( new LogList(), new LogList(), new LogList(), new LogList(),
                new LogList(), new LogList(), input);

        // BMI = 70 / (1.78^2) = 22.09
        String expected = "Your BMI is: 22.09";
        assertTrue(output.toString().contains(expected));
    }

    @Test
    void calculateBmi_negativeNumbers_expectFailure() {
        String input = "bmi /w -68 /h 1.78";
        assertThrows(HealthBudException.class, () -> new BMICommand(input));
    }

    @Test
    void calculateBmi_missingWeight_expectFailure() {
        String input = "bmi /h 1.78";
        assertThrows(InvalidBMIException.class, () -> new BMICommand(input));
    }

    @Test
    void calculateBmi_missingHeight_expectFailure() {
        String input = "bmi /w 70";
        assertThrows(InvalidBMIException.class, () -> new BMICommand(input));
    }

    @Test
    void calculateBmi_invalidNumberFormat_expectFailure() {
        String input = "bmi /w seventy /h 1.78";
        assertThrows(HealthBudException.class, () -> new BMICommand(input));
    }

    // ========================= Find Meal Tests =========================
    @Test
    void findMeal_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidFindException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "add meal chicken rice /cal 550 /d 12-01-25 /t 9pm";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        String findInput = "find meal chicken";
        new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);

        String expected = "1. chicken rice (550 cal) on: 12-01-25 at: 9pm";
        assertTrue(output.toString().contains(expected));
    }

    @Test
    void findMeal_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "find meal"; // missing keyword

        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }

    // ========================= Find water Tests =========================
    @Test
    void findWater_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidFindException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "add water /ml 500 /d 12-01-25 /t 8am";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        String findInput = "find water 12-01-25";
        new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);

        String expected = "1. 2.0 glass of water on (12-01-25) at 8am";
        assertTrue(output.toString().contains(expected));
    }

    @Test
    void findWater_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "find water"; // missing keyword

        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }

    // ========================= Find water Tests =========================
    @Test
    void findWorkout_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidFindException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "add workout bicep curls /r 20 /s 3 /d 12-01-25";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        String findInput = "find workout bicep curls";
        new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);

        String expected = "1. bicep curls (3 sets of 20) on 12-01-25";
        assertTrue(output.toString().contains(expected));
    }

    @Test
    void findWorkout_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "find workout"; // missing keyword

        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }

    // ========================= Delete meal Tests =========================
    @Test
    void deleteMeal_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidDeleteException, HealthBudException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "add meal chicken rice /cal 550 /d 12-01-25 /t 9pm";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        String deleteInput = "delete meal 1";
        new DeleteCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, deleteInput);

        String expected = "Noted. I've removed this log:";
        assertTrue(output.toString().contains(expected));
        assertEquals(0, mealLogs.getSize());

    }

    @Test
    void deleteMeal_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "delete meal"; // missing index


        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }

    // ========================= Delete water Tests =========================
    @Test
    void deleteWater_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidDeleteException, HealthBudException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String input = "add water /ml 500 /d 12-01-25 /t 8am";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, input);

        String deleteInput = "delete water 1";
        new DeleteCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, deleteInput);

        String expected = "Noted. I've removed this log:";
        assertTrue(output.toString().contains(expected));
        assertEquals(0, waterLogs.getSize());
    }

    @Test
    void deleteWater_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "delete water"; // missing index

        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }


    // ========================= Clear function Tests =========================
    @Test
    void clear_correctInput_expectSuccess() throws InvalidMealException, InvalidWorkoutException,
            InvalidWaterException, InvalidLogException, InvalidPBException, InvalidMLException,
            InvalidCardioException, InvalidClearException {
        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String firstInput = "add workout bicep curls /r 20 /s 3 /d 12-01-25";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, firstInput);
        String secondInput = "add workout bench press /r 10 /s 3 /d 12-01-25";
        new AddLogCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, secondInput);

        String deleteInput = "clear workout";
        new ClearCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, deleteInput);

        String expected = "Noted. I've removed all logs.";
        assertTrue(output.toString().contains(expected));
        assertEquals(0, workoutLogs.getSize());
    }

    @Test
    void clear_wrongInput_expectFailure() {

        LogList goalLogs = new LogList();
        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();

        String findInput = "clear"; // missing index

        assertThrows(Exception.class, () -> {
            new FindCommand().execute(goalLogs, pbLogs, mealLogs, workoutLogs, waterLogs, cardioLogs, findInput);
        });
    }

    // ========================= formatDate function Tests =========================
    @Test
    public void formatDate_validDates_expectSuccess() throws InvalidDateFormatException {
        assertEquals("Dec 25 2023", DateParser.formatDate("2023-12-25"));
        assertEquals("Dec 25 2023", DateParser.formatDate("12/25/2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("25/12/2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("Dec 25, 2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("December 25, 2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("20231225"));
        assertEquals("Dec 25 2023", DateParser.formatDate("25-12-2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("Mon, Dec 25, 2023"));
        assertEquals("Dec 25 2023", DateParser.formatDate("2023/12/25"));
        assertEquals("Dec 25 2023", DateParser.formatDate("12-25-2023"));
    }

    @Test
    public void formatDate_invalidDates_expectThrowsException() {
        assertThrows(InvalidDateFormatException.class, () -> DateParser.formatDate("2023-13-25")); // Invalid month
        assertThrows(InvalidDateFormatException.class, () -> DateParser.formatDate("32/12/2023")); // Invalid day
        assertThrows(InvalidDateFormatException.class, () -> DateParser.formatDate("random text")); // Random string
        assertThrows(InvalidDateFormatException.class,
                () -> DateParser.formatDate("2023-02-30")); // Invalid day in month
        assertThrows(InvalidDateFormatException.class, () -> DateParser.formatDate(null)); // Null input
        assertThrows(InvalidDateFormatException.class, () -> DateParser.formatDate("")); // Empty string
    }
    *//*


}

*/
