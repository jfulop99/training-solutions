package practice;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VowelFilterTest {

    @Test
    void filterVowels() {

        StringReader str = new StringReader("Aprócska\n" +
                "Kalapocska\n" +
                "Benne\n" +
                "Csacska\n" +
                "Macska\n" +
                "Mocska\n");

        String result;
        try (BufferedReader reader = new BufferedReader(str)) {
            result = new VowelFilter().filterVowels(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }

        assertEquals("prcsk\nKlpcsk\nBnn\nCscsk\nMcsk\nMcsk\n", result);

    }
}