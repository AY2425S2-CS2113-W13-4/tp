package seedu.healthbud;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserParameters {

    /**
     * Parses a command’s parameter section into a map.
     * Flags are indicated by a forward slash (e.g. "/cal").
     * The command input (without the command word itself) is assumed to start with
     * an optional free-text name, followed by any number of " /flag value" pairs.
     *
     * @param input the string to parse (e.g. "tomyum /cal 550 /d 12-01-25 /t 9pm")
     * @return a map where keys are flag names (without the slash) and values are the associated text.
     */
    public static Map<String, String> parseParameters(String input) {
        Map<String, String> params = new HashMap<>();
        Pattern pattern = Pattern.compile("/(\\w+)\\s+([^/]+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            params.put(matcher.group(1), matcher.group(2).trim());
        }
        return params;
    }
}
