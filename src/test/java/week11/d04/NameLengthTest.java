package week11.d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    void getLengths() {
        assertEquals(Arrays.asList(3, 4), NameLength.getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }
}