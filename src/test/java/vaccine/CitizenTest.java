package vaccine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CitizenTest {

    @Test
    void citizenCreateTest() {

        Citizen citizen = new Citizen("Kovács Géza", "2000", 23, "kovacs.geza@home.hu", "967168812");

        assertEquals("2000", citizen.getZipNumber());

    }

    @Test
    void citizenCreateWithIdTest() {

        Citizen citizen = new Citizen(12, "Kovács Géza", "2000", 23, "kovacs.geza@home.hu", "967168812");

        assertEquals(12, citizen.getId());

    }
}