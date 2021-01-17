package collectionsmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    private static final int NUMBER_OF_FIELDS = 3;
    private static final String FIELD_SEPARATOR = ":";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final int POSITION_OF_IP_ADDRESS = 0;
    private static final int POSITION_OF_DATE = 1;
    private static final int POSITION_OF_LOGIN = 2;

    public Map<String, List<Entry>> parseLog(String log) {

        Map<String, List<Entry>> logsByIpAddress = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new StringReader(log))) {
            String line = "";
            while ((line = reader.readLine()) != null) {

                addEntryToMap(logsByIpAddress, lineParser(line));

            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read", e);
        }
        return logsByIpAddress;
    }

    private void addEntryToMap(Map<String, List<Entry>> entries, Entry entry) {

        String ipAddress = entry.getIpAddress();
        if (entries.containsKey(ipAddress)) {
            entries.get(ipAddress).add(entry);
        }
        else {
            entries.put(ipAddress, new ArrayList<>(Arrays.asList(entry)));
        }
    }

    private Entry lineParser(String line) {
            String parts[] = line.split(FIELD_SEPARATOR);
            if (parts.length != NUMBER_OF_FIELDS) {
                throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
            }
            LocalDate date = dateParser(parts[POSITION_OF_DATE], DATE_FORMAT);
        return new Entry(parts[POSITION_OF_IP_ADDRESS], date, parts[POSITION_OF_LOGIN]);
    }

    private LocalDate dateParser(String date, String dateFormat) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));
        }catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }
}
