package week13.d04;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateEngineTest {

    @Test
    void merge() throws IOException {

        TemplateEngine templateEngine = new TemplateEngine();

        Map<String, Object> data = new HashMap<>();

        data.put("nev", "John Doe");
        data.put("datum", LocalDate.now());
        data.put("osszeg", 12324.50);
        data.put("hatarido", LocalDate.of(2021, 02,01));

        StringWriter writerString = new StringWriter();
        BufferedWriter writer = new BufferedWriter(writerString);

        String result = "Kedves John Doe!\n" +
                "Megküldjük önnek a következő esedékes számláját 2021-01-28 dátummal,\n" +
                "melynek összege: 12324.5 Ft!\n" +
                "A fizetési határidő 2021-02-01.\n" +
                "Üdvözlettel,\n" +
                "Ügyfélszolgálat\n";

        templateEngine.merge(new BufferedReader(new InputStreamReader(TemplateEngine.class.getResourceAsStream("template.txt"))),data, writer);

        assertEquals(result, writerString.toString());

    }


}