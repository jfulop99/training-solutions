package week11.d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    void getLengths() {
        List<Integer> length = new NameLength().getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William"));
        Collections.sort(length);
        assertEquals(Arrays.asList(3, 4),length );
    }

    @Test
    void getLengthsWithNullList() {
        List<Integer> length = new NameLength().getLengths(null);
        assertEquals(0, length.size());
    }

    @Test
    void getLengthsWithNullItem() {
        List<Integer> length = new NameLength().getLengths(Arrays.asList("Joe", "Jack", "Jane", "Jake", null, "William"));
        Collections.sort(length);
        assertEquals(Arrays.asList(3, 4),length);
    }

}