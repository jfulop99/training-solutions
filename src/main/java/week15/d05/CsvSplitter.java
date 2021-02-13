package week15.d05;

import java.util.ArrayList;
import java.util.List;

public class CsvSplitter {

    public static String[] split(String line) {
        return split(line, ",", "\"");
    }

    public static String[] split(String line, String dataSeparator) {
        return split(line, dataSeparator, "\"");
    }

    public static String[] split(String line, String dataSeparators, String stringSeparators) {

        if (line == null || line.isBlank()) {
            return new String[]{""};
        }

        if (dataSeparators == null || dataSeparators.isEmpty()) {
            dataSeparators = ",";
        }

        if (stringSeparators == null || stringSeparators.isEmpty()) {
            stringSeparators = "\"";
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
