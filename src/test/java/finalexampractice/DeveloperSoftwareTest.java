package finalexampractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeveloperSoftwareTest {

    @Test
    void increasePrice() {

        DeveloperSoftware developerSoftware = new DeveloperSoftware("Java", 1000D);

        assertEquals(1000, developerSoftware.getPrice());
        assertEquals("Java", developerSoftware.getName());
        developerSoftware.increasePrice();
        assertEquals(1100, developerSoftware.getPrice());

    }
}