package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarkTest {

    public static final Subject SUBJECT = new Subject("matematika");
    public static final Tutor TUTOR = new Tutor("Nagy Lilla", Arrays.asList(SUBJECT));


    @Test
    public void nullParameterShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Mark(MarkType.A, null, TUTOR));
        assertEquals("Both subject and tutor must be provided!", ex.getMessage());
    }

    @Test
    public void testCreate() {
        Mark mark = new Mark(MarkType.A, SUBJECT, TUTOR);
        assertEquals(MarkType.A, mark.getMarkType());
        assertEquals(SUBJECT, mark.getSubject());
        assertEquals(TUTOR, mark.getTutor());
        assertEquals("excellent(5)", mark.toString());
    }
    // Saját tesztek a második konstruktorhoz.
    @Test
    void testCreateWithString() {
        Mark mark = new Mark("A", SUBJECT, TUTOR);
        assertEquals(MarkType.A, mark.getMarkType());
        assertEquals(SUBJECT, mark.getSubject());
        assertEquals(TUTOR, mark.getTutor());
        assertEquals("excellent(5)", mark.toString());
    }

    @Test
    public void nullStringParameterShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Mark((String)null, SUBJECT, TUTOR));
        assertEquals("Marktype, subject and tutor must be provided!", ex.getMessage());
    }

    @Test
    public void wrongStringParameterShouldThrowException() throws IllegalArgumentException {
        String mark = "E";
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Mark(mark, SUBJECT, TUTOR));
        assertEquals("Marktype must be A,B,C,D,F not "+ mark + ".", ex.getMessage());
    }

}
