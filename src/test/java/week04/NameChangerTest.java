package week04;

import org.junit.jupiter.api.Test;
import stringscanner.StringScanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {

    @Test
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(null));
        assertEquals("Invalid Name:  null", ex.getMessage());


    }

    @Test
    public void parameterIsEmptyShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid Name:  ", ex.getMessage());


    }

    @Test
    public void changeFistname() {
        NameChanger nameChanger = new NameChanger("John Doe");
        assertEquals("John Doe", nameChanger.getFullName());
        nameChanger.changeFirstName("Jack");
        assertEquals("Jack Doe", nameChanger.getFullName());
    }
}