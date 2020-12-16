package week08.d03.mid;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void unionTest() {
        StringLists stringLists = new StringLists();

        assertEquals("[b, c, d, a, e]", stringLists.stringListsUnion(List.of("b","c","d"), List.of("a","b","c","d","e")).toString());

    }

}