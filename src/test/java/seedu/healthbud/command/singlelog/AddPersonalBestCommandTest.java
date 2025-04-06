package seedu.healthbud.command.singlelog;

import org.junit.jupiter.api.Test;
import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidDateException;
import seedu.healthbud.exception.InvalidDateFormatException;
import seedu.healthbud.exception.InvalidPersonalBestException;
import seedu.healthbud.log.PersonalBest;
import seedu.healthbud.parser.addcommandparser.AddPersonalBestParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddPersonalBestCommandTest {

    @Test
    void addPersonalBest_validInput_success() throws Exception {
        LogList pbLogs = new LogList();
        String input = "add pb deadlift /w 120 /d 01-01-2025";

        AddPersonalBestCommand command = AddPersonalBestParser.parse(pbLogs, input);
        command.execute();

        assertEquals(1, pbLogs.getSize());
        PersonalBest pb = (PersonalBest) pbLogs.getLog(0);
        assertEquals("deadlift", pb.getExercise());
        assertEquals("120", pb.getWeight());
        assertEquals("01 Jan 2025", pb.getDate());
    }

    @Test
    void addPersonalBest_missingWeight_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb bench /d 01-01-25";

        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_missingDate_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb squat /w 140";

        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_nonNumericWeight_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb press /w heavy /d 01-01-25";

        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_invalidDateFormat_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb squat /w 90 /d wrong-date";

        assertThrows(InvalidDateException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }


    @Test
    void addPersonalBest_emptyName_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb /w 100 /d 01-01-25";

        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_emptyWeight_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb pull-up /w  /d 01-01-2025";
        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_emptyDate_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb deadlift /w 100 /d  ";
        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_invalidKey_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb snatch /weight 90 /d 01-01-2025";
        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_extraKey_throwsException() {
        LogList pbLogs = new LogList();
        String input = "add pb pushup /w 50 /d 01-01-2025 /note intense";
        assertThrows(InvalidPersonalBestException.class, () -> AddPersonalBestParser.parse(pbLogs, input));
    }

    @Test
    void addPersonalBest_nullInput_throwsAssertionError() {
        LogList pbLogs = new LogList();
        assertThrows(AssertionError.class, () -> AddPersonalBestParser.parse(pbLogs, null));
    }

}
