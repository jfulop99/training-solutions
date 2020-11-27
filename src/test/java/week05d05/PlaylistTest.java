package week05d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void findByLengthGreaterThan() {


        List<Song> playlists = new ArrayList<>();
        playlists.add(new Song("Child in time", 330, "Deep Purple"));
        playlists.add(new Song("Song 1", 130, "Artist1"));
        playlists.add(new Song("Song 2", 220, "Artist2"));
        playlists.add(new Song("Song 3", 90, "Artist3"));
        playlists.add(new Song("Song 4", 180, "Artist4"));
        Playlist playlist = new Playlist(playlists);
        System.out.println(playlist);
        Playlist pls = playlist.findByLengthGreaterThan(3);
        System.out.println(pls);
        Assertions.assertEquals("Playlist:\n" +
                "Song: Child in time                  Length:  5:30 Artist: Deep Purple         \n" +
        //        "Song: Song 1                         Length:  2:10 Artist: Artist1             \n" +
                "Song: Song 2                         Length:  3:40 Artist: Artist2             \n" +
                "Song: Song 4                         Length:  3:00 Artist: Artist4             \n", pls.toString());

    }

    @Test
    void testWithNull() throws IllegalArgumentException{
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Playlist(null));
        assertEquals("Playlist is cannot be null.", e.getMessage());
    }
}