package week04.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameChangerTest {

    @Test
    public void parameterIsNullShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(null));
        assertEquals("Invalid Name: null", ex.getMessage());


    }

    @Test
    public void parameterIsEmptyShouldThrowException() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid Name: ", ex.getMessage());


    }

    @Test
    public void changeFistname() {
        NameChanger nameChanger = new NameChanger("John Doe");
        assertEquals("John Doe", nameChanger.getFullName());
        nameChanger.changeFirstName("Jack");
        assertEquals("Jack Doe", nameChanger.getFullName());
    }
    @Test
    public void IsTheSameTest() {
        NameChanger nameChanger = new NameChanger("Doe John");
        assertTrue(nameChanger.isTheSame("Doe John"));
    }
}