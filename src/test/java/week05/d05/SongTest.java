package week05.d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    private Song song;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testToString() {
        song = new Song("Child in time", 330, "Deep Purple");
        assertEquals("Song: Child in time                  Length:  5:30 Artist: Deep Purple         ", song.toString());
    }

    @Test
    void testGetName() {
        song = new Song("Child in time", 330, "Deep Purple");
        assertEquals("Child in time", song.getName());
    }

    @Test
    void testGetLengthInSeconds() {
        song = new Song("Child in time", 330, "Deep Purple");
        assertEquals(330L, song.getLengthInSeconds());
    }

    @Test
    void testGetArtist() {
        song = new Song("Child in time", 330, "Deep Purple");
        assertEquals("Deep Purple", song.getArtist());
    }

    @Test
    void testEmptyName() throws IllegalArgumentException {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song(" ", 330, "Deep Purple"));
    }

    @Test
    void testEmptyArtist() throws IllegalArgumentException {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Child in time", 330, " "));
    }

    @Test
    void testNullName() throws IllegalArgumentException {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song(null, 330, "Deep Purple"));
    }

    @Test
    void testNullArtist() throws IllegalArgumentException {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Child in time", 330, null));
    }

    @Test
    void testZeroLength() throws IllegalArgumentException {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Song("Child in time", 0, "Deep Purple"));
    }
}