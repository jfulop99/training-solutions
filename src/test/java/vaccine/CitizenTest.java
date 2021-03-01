package vaccine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void invalidNameThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Citizen(null, "2000", 23, "kovacs.geza@home.hu", "967168812"));
        assertEquals("Fullname cannot be empty", exception.getMessage());
    }

    @Test
    void invalidPostalCodeThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "000", 23, "kovacs.geza@home.hu", "967168812"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "a000", 23, "kovacs.geza@home.hu", "967168812"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", null, 23, "kovacs.geza@home.hu", "967168812"));
        assertEquals("Invalid postal code", exception.getMessage());
    }

    @Test
    void invalidAgeThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 9, "kovacs.geza@home.hu", "967168812"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 160, "kovacs.geza@home.hu", "967168812"));
        assertEquals("Must be between 10 - 150", exception.getMessage());
    }

    @Test
    void invalidEmailThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 23, "kovacs.gezahome.hu", "967168812"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 23, "kovacs.geza@homehu", "967168812"));
        assertEquals("E-mail address is invalid", exception.getMessage());
    }

    @Test
    void invalidTajThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 23, "kovacs.geza@home.hu", "967168811"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 23, "kovacs.geza@home.hu", "9671688120"));
        exception = assertThrows(IllegalArgumentException.class, () -> new Citizen("Kovács Géza", "2000", 23, "kovacs.geza@home.hu", "9671a8812"));
        assertEquals("TAJ number must be valid", exception.getMessage());
    }
}