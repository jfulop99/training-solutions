package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    void merge(BufferedReader reader, Map<String, Object> data, BufferedWriter writer) {

        try (reader; writer){
            String line;
            while ((line = reader.readLine()) != null) {



                writer.write((lineProcessor(line, data)) + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
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


    public static void main(String[] args) {

        TemplateEngine templateEngine = new TemplateEngine();

        Map<String, Object> data = new HashMap<>();

        data.put("nev", "John Doe");
        data.put("datum", LocalDate.now());
        data.put("osszeg", 12324.50);
        data.put("hatarido", LocalDate.of(2021, 02,01));


        try {
            templateEngine.merge(new BufferedReader(new InputStreamReader(TemplateEngine.class.getResourceAsStream("template.txt"))),data, Files.newBufferedWriter(Path.of("output.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
