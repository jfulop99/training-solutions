package week09.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {

    @Test
    void getThroughChimneysTest() {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Apa", 43));
        people.add(new Person("Anya", 40));
        people.add(new Person("Betti", 8));
        people.add(new Person("Borcsi", 11));
        people.add(new Person("Bence", 16));
        people.add(new Person("Nagyi", 70));

        SantaClaus santaClaus = new SantaClaus(people, new Random(1));

        santaClaus.getThroughChimneys();

        List<Person> people1 = santaClaus.getPeople();

        assertEquals(43, people1.get(0).getAge());
        assertEquals("Anya", people1.get(1).getName());
        assertEquals(Present.TOY, people1.get(3).getPresent());
        assertEquals(Present.HOUSEKEEPING, people1.get(5).getPresent());
    }

    @Test
    void listIsNullTest() {
        assertThrows(Exception.class, () -> new SantaClaus(null, new Random(1)));
    }
    @Test
    void listIsEmptyTest() {
        assertThrows(Exception.class, () -> new SantaClaus(new ArrayList<>(), new Random(1)));
    }
    @Test
    void rndIsNullTest() {
        assertThrows(Exception.class, () -> new SantaClaus(new ArrayList<>(), null));
    }
}