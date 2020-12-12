package week07.d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {


    @Test
    void constructorTest() {
        Lab lab1 = new Lab("Exception");
        Lab lab2 = new Lab("Inheritance", LocalDate.of(2020, 12, 06));
        Lab lab3 = new Lab("Exception");
        assertFalse(lab1.isCompleted());
        assertTrue(lab2.isCompleted());
        assertFalse(lab3.isCompleted());
        assertEquals(lab1.getTitle(), "Exception");
        assertEquals(lab2.getTitle(), "Inheritance");
        assertEquals(lab3.getTitle(), "Exception");
        assertEquals(null, lab1.getCompletedAt());
        assertEquals(LocalDate.of(2020,12,06), lab2.getCompletedAt());
        assertEquals(null, lab3.getCompletedAt());

    }

    @Test
    void completedTest() {
        Lab lab1 = new Lab("Exception");
        Lab lab2 = new Lab("Inheritance", LocalDate.of(2020, 12, 06));
        Lab lab3 = new Lab("Exception");
        lab1.complete();
        lab3.complete(LocalDate.of(2020,12,9));
        assertTrue(lab1.isCompleted());
        assertTrue(lab2.isCompleted());
        assertTrue(lab3.isCompleted());
        assertEquals(LocalDate.now(), lab1.getCompletedAt());
        assertEquals(LocalDate.of(2020,12,06), lab2.getCompletedAt());
        assertEquals(LocalDate.of(2020,12,9), lab3.getCompletedAt());
    }
}