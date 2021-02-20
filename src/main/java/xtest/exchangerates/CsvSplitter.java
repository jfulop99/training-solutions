package xtest.exchangerates;

import java.util.ArrayList;
import java.util.List;

public class CsvSplitter {

    public static final String DEFAULT_STRING_SEPARATOR = "\"";
    public static final String DEFAULT_FIELD_SEPARATOR = ",";

    public static String[] split(String line) {
        return split(line, DEFAULT_FIELD_SEPARATOR, DEFAULT_STRING_SEPARATOR);
    }

    public static String[] split(String line, String dataSeparator) {
        return split(line, dataSeparator, DEFAULT_STRING_SEPARATOR);
    }

    public static String[] split(String line, String dataSeparators, String stringSeparators) {

        if (line == null || line.isBlank()) {
            return new String[]{""};
        }

        if (dataSeparators == null || dataSeparators.isEmpty()) {
            dataSeparators = DEFAULT_FIELD_SEPARATOR;
        }

        if (stringSeparators == null || stringSeparators.isEmpty()) {
            stringSeparators = DEFAULT_STRING_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        List<String> parts = new ArrayList<>();

        boolean inside = false;
        for (char c : line.toCharArray()) {
            if (stringSeparators.indexOf(c) >= 0) {
                inside = !inside;
            }
            if (dataSeparators.indexOf(c) < 0 || inside) {
                if (stringSeparators.indexOf(c) < 0) {
                    sb.append(c);
                }
            } else {
                parts.add(sb.toString().trim());
                sb = new StringBuilder();
            }
        }
        parts.add(sb.toString().trim());

        return parts.toArray(String[]::new);
    }
}
