package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void getIndexesOfCharTestIfThere() {

        Main main = new Main();

        assertEquals("[0, 3, 5, 7, 10]", main.getIndexesOfChar1 ("abrakadabra", 'a').toString());
        assertEquals("[0, 3, 5, 7, 10]", main.getIndexesOfChar2 ("abrakadabra", 'a').toString());
        assertEquals("[0, 3, 5, 7, 10]", main.getIndexesOfChar3 ("abrakadabra", 'a').toString());
    }

    @Test
    void getIndexesOfCharTestIfThereIsNot() {

        Main main = new Main();

        assertEquals("[]", main.getIndexesOfChar1 ("abrakadabra", 'c').toString());
        assertEquals("[]", main.getIndexesOfChar2 ("abrakadabra", 'c').toString());
        assertEquals("[]", main.getIndexesOfChar3 ("abrakadabra", 'c').toString());
    }

    @Test
    void getIndexesOfCharTestAll() {

        Main main = new Main();

        assertEquals("[0, 1, 2, 3, 4, 5, 6]", main.getIndexesOfChar1 ("ccccccc", 'c').toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6]", main.getIndexesOfChar2 ("ccccccc", 'c').toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6]", main.getIndexesOfChar3 ("ccccccc", 'c').toString());
    }

    @Test
    void getIndexesOfCharTestEmpty() {

        Main main = new Main();

        assertEquals("[]", main.getIndexesOfChar1 ("", 'c').toString());
        assertEquals("[]", main.getIndexesOfChar2 ("", 'c').toString());
        assertEquals("[]", main.getIndexesOfChar3 ("", 'c').toString());
    }

}
