package week05d05;

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
        Playlist playlist = new Playlist(playlists);
        System.out.println(playlist);
        System.out.println(playlist.findByLengthGreaterThan(2));


    }
}