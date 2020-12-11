package week04d02;

import org.junit.jupiter.api.Test;
import week04d02.Search;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    @Test
    void getIndexesOfCharTestIfThere() {

        Search search = new Search();

        assertEquals("[0, 3, 5, 7, 10]", search.getIndexesOfChar1 ("abrakadabra", 'a').toString());
        assertEquals("[0, 3, 5, 7, 10]", search.getIndexesOfChar2 ("abrakadabra", 'a').toString());
        assertEquals("[0, 3, 5, 7, 10]", search.getIndexesOfChar3 ("abrakadabra", 'a').toString());
    }

    @Test
    void getIndexesOfCharTestIfThereIsNot() {

        Search search = new Search();

        assertEquals("[]", search.getIndexesOfChar1 ("abrakadabra", 'c').toString());
        assertEquals("[]", search.getIndexesOfChar2 ("abrakadabra", 'c').toString());
        assertEquals("[]", search.getIndexesOfChar3 ("abrakadabra", 'c').toString());
    }

    @Test
    void getIndexesOfCharTestAll() {

        Search search = new Search();

        assertEquals("[0, 1, 2, 3, 4, 5, 6]", search.getIndexesOfChar1 ("ccccccc", 'c').toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6]", search.getIndexesOfChar2 ("ccccccc", 'c').toString());
        assertEquals("[0, 1, 2, 3, 4, 5, 6]", search.getIndexesOfChar3 ("ccccccc", 'c').toString());
    }

    @Test
    void getIndexesOfCharTestEmpty() {

        Search search = new Search();

        assertEquals("[]", search.getIndexesOfChar1 ("", 'c').toString());
        assertEquals("[]", search.getIndexesOfChar2 ("", 'c').toString());
        assertEquals("[]", search.getIndexesOfChar3 ("", 'c').toString());
    }

}
