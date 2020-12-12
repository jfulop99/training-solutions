package week06.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListSelectorTest {

    @Test
    void evenSelector() {
        ListSelector listSelector = new ListSelector();
        assertEquals("[1, 3, 5, 7]", listSelector.evenSelector(Arrays.asList("1","2","3","4","5","6","7")));
    }
    @Test
    void evenSelectorWithNull()  throws IllegalArgumentException {
        ListSelector listSelector = new ListSelector();
        Exception e = assertThrows(IllegalArgumentException.class, () -> listSelector.evenSelector(null));

        assertEquals("Input list is null", e.getMessage());
    }
}