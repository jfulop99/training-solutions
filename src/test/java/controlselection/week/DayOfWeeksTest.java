package controlselection.week;

import controlselection.greetings.Greetings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DayOfWeeksTest {
    @Test
    void testCreate(){
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        assertEquals("hét eleje", dayOfWeeks.dayOfWeeks("Hétfő"));
        assertEquals("hét közepe", dayOfWeeks.dayOfWeeks("Kedd"));
        assertEquals("hét közepe", dayOfWeeks.dayOfWeeks("Szerda"));
        assertEquals("hét közepe", dayOfWeeks.dayOfWeeks("Csütörtök"));
        assertEquals("majdnem hétvége", dayOfWeeks.dayOfWeeks("Péntek"));
        assertEquals("hét vége", dayOfWeeks.dayOfWeeks("Szombat"));
        assertEquals("hét vége", dayOfWeeks.dayOfWeeks("Vasárnap"));
    }
    @Test
    void testEXeption(){
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        assertThrows(IllegalArgumentException.class, () -> dayOfWeeks.dayOfWeeks("dodszerda") );
    }
    @Test
    void testCase(){
        DayOfWeeks dayOfWeeks = new DayOfWeeks();
        assertEquals("hét eleje", dayOfWeeks.dayOfWeeks("HéTfŐ"));
    }

}
