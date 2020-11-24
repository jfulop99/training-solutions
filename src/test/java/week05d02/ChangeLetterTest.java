package week05d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week04.NameChanger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {

    private ChangeLetter changeLetter = new ChangeLetter();



    @Test
    void callWithNullTest(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> changeLetter.changeVowels(null));
        assertEquals("Invalid input: null", ex.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> changeLetter.changeVowels2(null));
        assertEquals("Invalid input: null", ex2.getMessage());

    }

    @Test
    void callWithEmpty(){
        assertEquals("", changeLetter.changeVowels(""));
        assertEquals("", changeLetter.changeVowels2(""));
    }

    @Test
    void callWithGood(){
        assertEquals("C*c* c*l*", changeLetter.changeVowels("Coca cola"));
        assertEquals("L*r*m *ps*m h*s b**n th* *nd*stry's st*nd*rd d*mmy t*xt *v*r s*nc* th* 1500s", changeLetter.changeVowels("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
        assertEquals("C*c* c*l*", changeLetter.changeVowels2("Coca cola"));
        assertEquals("L*r*m *ps*m h*s b**n th* *nd*stry's st*nd*rd d*mmy t*xt *v*r s*nc* th* 1500s", changeLetter.changeVowels2("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));
    }

}
