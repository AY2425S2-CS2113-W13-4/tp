package seedu.healthbud.parser;

import seedu.healthbud.exception.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateParser {

    private static final String OUTPUT_FORMAT = "dd MMM yyyy";

    // List of possible input date formats to try
    private static final List<String> INPUT_FORMATS = Arrays.asList(
            "yyyy-MM-dd",       // ISO format (e.g., 2023-12-25)
            "MM/dd/yyyy",      // US format (e.g., 12/25/2023)
            "dd/MM/yyyy",      // European format (e.g., 25/12/2023)
            "MMM dd, yyyy",    // (e.g., Dec 25, 2023)
            "MMMM dd, yyyy",   // (e.g., December 25, 2023)
            "yyyyMMdd",        // (e.g., 20231225)
            "dd-MM-yyyy",      // (e.g., 25-12-2023)
            "EEE, MMM dd, yyyy", // (e.g., Mon, Dec 25, 2023)
            "yyyy/MM/dd",      // (e.g., 2023/12/25)
            "MM-dd-yyyy",      // (e.g., 12-25-2023)
            "MMM dd yyyy"
    );

    public static String formatDate(String inputDate) throws InvalidDateFormatException {
        if (inputDate == null || inputDate.trim().isEmpty()) {
            throw new InvalidDateFormatException(inputDate,INPUT_FORMATS);
        }

        // Try each format until one works
        for (String format : INPUT_FORMATS) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false); // Strict parsing
                Date date = sdf.parse(inputDate);

                // Format to the desired output
                SimpleDateFormat outputSdf = new SimpleDateFormat(OUTPUT_FORMAT);
                return outputSdf.format(date);
            } catch (ParseException e) {
                // Try next format
            }
        }

        throw new InvalidDateFormatException(inputDate,INPUT_FORMATS);

    }
}
