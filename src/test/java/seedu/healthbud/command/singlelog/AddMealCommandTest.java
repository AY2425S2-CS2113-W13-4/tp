package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Meal;
import seedu.healthbud.parser.addcommandparser.AddMealParser;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidMealException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.exception.InvalidMLException;

class AddMealCommandTest {

    @Test
    void mealLog_missingName_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal /cal 550 /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_missingCaloriesParameter_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void mealLog_nonNumericCalories_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal high /d 12-01-2025 /t 9pm";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void addMeal_emptyInput_expectThrowsInvalidMealException() {
        LogList mealLogs = new LogList();
        String input = "add meal";

        assertThrows(InvalidMealException.class, () -> AddMealParser.parse(mealLogs, input));
    }

    @Test
    void validMealAddsToLogList_expectSuccess() throws InvalidPersonalBestException, InvalidMLException
            , InvalidCardioException {

        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025 /t 9pm";

        AddMealCommand command = new AddMealCommand(mealLogs, input, "chicken rice", "550", "12 Jan 2025", "9pm");

        command.execute();

        Meal meal = (Meal) mealLogs.getLog(0);
        assertEquals("chicken rice", meal.getName());
        assertEquals("550", meal.getCalories());
        assertEquals("12 Jan 2025", meal.getDate());
        assertEquals("9pm", meal.getTime());

        String expected = "chicken rice (550 cal) on: 12 Jan 2025 at: 9pm";
        assertEquals(expected, meal.toString());
    }
}
