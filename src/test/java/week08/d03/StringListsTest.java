package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    @Test
    void shortestWordsTest() {

        StringLists stringLists = new StringLists();

        assertEquals("[aa, bb, dd]", stringLists.shortestWords(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")).toString());
        assertEquals("[aa, bb, dd]", stringLists.shortestWords2(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")).toString());
        assertEquals("[aa, bb, dd]", stringLists.shortestWords3(Arrays.asList("aaa", null, "aa", "bb", "cccc", "dd")).toString());
    }

}