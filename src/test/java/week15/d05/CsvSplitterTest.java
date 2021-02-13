package week15.d05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvSplitterTest {

    private String s;
    private String[] words;

    @BeforeEach
    void setUp() {
        s = " alma   ,,   \"korte, korte\",9:38,\"11:12\",   meggy ,";
    }

    @AfterEach
    void setDown() {
        Arrays.stream(words).forEach(System.out::println);
        System.out.println(words.length);
        words = new String[1];
    }

    @Test
    void testSplit() {
        words = CsvSplitter.split(s);
        assertEquals(7, words.length);
        assertEquals("9:38", words[3]);
    }

    @Test
    void testSplitWithDataSeparator() {
        words = CsvSplitter.split(s, ",:");
        assertEquals(8, words.length);
        assertEquals("9", words[3]);
    }

    @Test
    void testSplitWithDataAndStringSeparator() {
        words = CsvSplitter.split(s, ",:", "'");
        assertEquals(10, words.length);
        assertEquals("9", words[4]);
        words = CsvSplitter.split(" alma   ,,   'korte, korte',9:38,'11:12',   meggy ,", ",:", "'");
        assertEquals(8, words.length);
        assertEquals("11:12", words[5]);
    }

    @Test
    void testSplitWithNullLine() {
        words = CsvSplitter.split(null);
        assertEquals(1, words.length);
        assertEquals("", words[0]);
    }

    @Test
    void testSplitWithNullSeparators() {
        words = CsvSplitter.split(s, null, null);
        assertEquals(7, words.length);
        assertEquals("9:38", words[3]);
    }
}
