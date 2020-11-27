package week05d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void testToString() {
        Song song = new Song("Child in time", 330, "Deep Purple");
        assertEquals("Song: Child in time                  Length: 5:30 Artist: Deep Purple         ", song.toString());
    }

    @Test
    void getName() {
    }

    @Test
    void getLengthInSeconds() {
    }

    @Test
    void getArtist() {
    }
}