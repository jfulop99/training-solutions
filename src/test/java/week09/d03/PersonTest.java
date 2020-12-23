package week09.d03;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private static Random rnd = new Random(1);

    @Test
    void personUnder14() {
        Person person = new Person("Betti", 8);

        person.setPresent(rnd);

        assertEquals( Present.HOUSEKEEPING, person.getPresent());
    }

    @Test
    void personOver14() {
        Person person = new Person("Anya", 43);

        person.setPresent(rnd);

        assertEquals( Present.ELECTRONIC, person.getPresent());
    }

    @Test
    void ageLessThanZero() {

        assertThrows(Exception.class, () -> new Person("Anya", -2));
    }

    @Test
    void nameisNull() {

        assertThrows(Exception.class, () -> new Person(null, 23));
    }

    @Test
    void nameIsBlank() {

        assertThrows(Exception.class, () -> new Person("     ", 23));
    }


}