package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingsTest {
    @Test
    void testCreate(){
        Greetings greetings = new Greetings();
        assertEquals("Jó éjt!", greetings.greetings(4, 30));
        assertEquals("Jó éjt!", greetings.greetings(5, 0));
        assertEquals("Jó reggelt!", greetings.greetings(5, 1));
        assertEquals("Jó reggelt!", greetings.greetings(9, 0));
        assertEquals("Jó napot!", greetings.greetings(9, 1));
        assertEquals("Jó napot!", greetings.greetings(18, 30));
        assertEquals("Jó estét!", greetings.greetings(18, 31));
        assertEquals("Jó estét!", greetings.greetings(20, 00));
        assertEquals("Jó éjt!", greetings.greetings(20, 01));
    }

}
