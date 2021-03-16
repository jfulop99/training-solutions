package finalexampractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {

        Software software = new OfficeSoftware("Office", 2000D);

        assertEquals(2000, software.getPrice());
        assertEquals("Office", software.getName());

        software.increasePrice();

        assertEquals(2100, software.getPrice());

    }
}