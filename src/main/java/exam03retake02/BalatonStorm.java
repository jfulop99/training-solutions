package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();

        String line;
        String stationName = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("\"allomas\"")) {
                stationName = line.split("\"")[3];
            }
            if (line.contains("\"level\"")) {
                int lineLength = line.length();
                int level = Integer.parseInt(line.substring(lineLength - 2, lineLength - 1));
                if (level == 3) {
                    result.add(stationName);
                }
            }
        }
        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

}
