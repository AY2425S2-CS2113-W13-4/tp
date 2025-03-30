package seedu.healthbud.parser;

import java.util.HashMap;
import java.util.Map;

public class ParserParameters {
    public static Map<String, String> parseParameters(String input) {
        Map<String, String> params = new HashMap<>();
        String[] tokens = input.split("\\s+");

        String currentKey = null;
        StringBuilder currentValue = new StringBuilder();

        for (String token : tokens) {
            if (token.startsWith("/")) {
                // Save previous key-value pair
                if (currentKey != null) {
                    params.put(currentKey, currentValue.toString().trim());
                    currentValue.setLength(0);
                }
                currentKey = token.substring(1); // Remove the '/'
            } else if (currentKey != null) {
                if (currentValue.length() > 0) {
                    currentValue.append(" ");
                }
                currentValue.append(token);
            }
        }

        // Add the last parameter
        if (currentKey != null) {
            params.put(currentKey, currentValue.toString().trim());
        }

        return params;
    }
}
