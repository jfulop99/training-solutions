package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class TemplateEngine {

    public static final String OPEN_SIGN = "{";
    public static final String CLOSE_SIGN = "}";

    void merge(BufferedReader reader, Map<String, Object> data, BufferedWriter writer) throws IOException {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write((lineProcessorWithMoreKeys(line, data)) + "\n");
            }

    }


    private String lineProcessor(String line, Map<String, Object> data) {

        int kezd = 0;
        int veg = 0;

        String outLine = line;

        if ((kezd = line.indexOf("{")) > 0) {
            veg = line.indexOf("}");

            String key = line.substring(kezd + 1, veg);

            String replace = "{" + key + "}";

            outLine = line.replace(replace, data.get(key).toString());

        }
        return outLine;
    }

    private String lineProcessorWithMoreKeys(String line, Map<String, Object> data) {

        int indexOfOpen= 0;
        int indexOfClose= 0;
        String result = line;

        while ((indexOfOpen = result.indexOf(OPEN_SIGN, indexOfClose)) > 0 ) {
            indexOfClose = result.indexOf(CLOSE_SIGN, indexOfOpen);
            String key = result.substring(indexOfOpen + 1, indexOfClose);

            String value = getStringValue(data.get(key));

            result = result.replace(OPEN_SIGN + key + CLOSE_SIGN, value);
        }
        return result;
    }

    private String getStringValue(Object keyValue) {
        String value = "";
        if (keyValue instanceof LocalDate) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy. MMMM dd.");
            value = ((LocalDate) keyValue).format(format);
        }
        else if (keyValue instanceof Double) {
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("hu", "HU"));
            value = format.format(keyValue);
        }
        else {
            value = keyValue.toString();
        }
        return value;
    }


    public static void main(String[] args) {

        TemplateEngine templateEngine = new TemplateEngine();

        Map<String, Object> data = Map.of("nev", "John Doe",
                "datum", LocalDate.now(),
                "osszeg", 12324.50,
                "hatarido", LocalDate.now().plusDays(30));


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(TemplateEngine.class.getResourceAsStream("template.txt"))); BufferedWriter writer = Files.newBufferedWriter(Path.of("output.txt"))){
            templateEngine.merge(reader,data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
