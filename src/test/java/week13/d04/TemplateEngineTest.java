package week13.d04;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateEngineTest {

    @Test
    void merge() {

        TemplateEngine templateEngine = new TemplateEngine();

        Map<String, Object> data = Map.of("nev", "John Doe",
                "datum", LocalDate.now(),
                "osszeg", 12324.5,
                "hatarido", LocalDate.now().plusDays(30));

        StringWriter writerString = new StringWriter();
        BufferedWriter writer = new BufferedWriter(writerString);

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM dd."));
        String endDate = LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("yyyy. MMMM dd."));


        String result = "Kedves John Doe!          " + date + "\n" +
                "Megküldjük önnek a következő esedékes számláját " + date + " dátummal,\n" +
                "melynek összege: 12\u00A0324,50\u00A0Ft!\n" +
                "A fizetési határidő: " + endDate + "\n" +
                "Üdvözlettel,\n" +
                "Ügyfélszolgálat\n";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(TemplateEngine.class.getResourceAsStream("template.txt"))); writer ) {

            templateEngine.merge(reader, data, writer);

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        assertEquals(result, writerString.toString());
    }


}