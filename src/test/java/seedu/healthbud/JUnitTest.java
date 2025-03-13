package seedu.healthbud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import seedu.healthbud.exception.HealthBudException;

import org.junit.jupiter.api.Test;
import seedu.healthbud.log.Meal;

import java.util.ArrayList;

class JUnitTest {
    @Test
    void handleMeal_correctInput_expectSuccess() throws HealthBudException {
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
    void handleMeal_wrongInput_expectFailure() throws HealthBudException {
        LogList logs = new LogList();
        // Missing calories parameter "/cal"
        String input = "meal Chicken Rice /d 12-01-25 /t 9pm";

        assertThrows(HealthBudException.class, () -> Parser.handleMeal(logs, input));
    }

    @Test
    void mealLog_nullInput_expectException() throws HealthBudException{
        LogList logs = new LogList();
        String input = null;

        assertThrows(HealthBudException.class, () -> Parser.handleMeal(logs, input));
    }
}
