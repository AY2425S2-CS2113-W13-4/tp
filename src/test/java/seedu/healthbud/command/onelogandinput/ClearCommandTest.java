package seedu.healthbud.command.onelogandinput;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidCardioException;
import seedu.healthbud.exception.InvalidClearException;
import seedu.healthbud.exception.InvalidMLException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.parser.ClearParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class ClearCommandTest {
    @Test
    void clear_correctInput_expectSuccess() throws InvalidPersonalBestException, InvalidMLException,
            InvalidCardioException, InvalidClearException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        LogList mealLogs = new LogList();
        String input = "add meal chicken rice /cal 550 /d 12-01-2025 /t 9pm";
        String secondInput = "add meal tom yum /cal 650 /d 13-01-2025 /t 8pm";

        AddMealCommand addCommand1 = new AddMealCommand(mealLogs, input, "chicken rice", "550", "12 Jan 2025", "9pm");
        AddMealCommand addCommand2 = new AddMealCommand(mealLogs, secondInput, "tom yum", "650", "13 Jan 2025", "8pm");

        addCommand1.execute();
        addCommand2.execute();

        assertEquals(2, mealLogs.getSize());

        String clearInput = "clear meal";
        ClearCommand clearCommand = new ClearCommand(clearInput, mealLogs);
        clearCommand.execute();

        assertEquals(0, mealLogs.getSize());
    }

    @Test
    void clear_wrongInput_expectFailure() {

        LogList mealLogs = new LogList();
        LogList workoutLogs = new LogList();
        LogList pbLogs = new LogList();
        LogList waterLogs = new LogList();
        LogList cardioLogs = new LogList();
        String input = "clear"; // invalid input, missing log type


        assertThrows(InvalidClearException.class, () -> {
            ClearParser.parse(input, mealLogs, workoutLogs, waterLogs, pbLogs, cardioLogs);
        });
    }
}
