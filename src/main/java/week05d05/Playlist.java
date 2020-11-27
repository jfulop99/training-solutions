package week05d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playlist {

    private List<Song> playlist;

    public Playlist(List<Song> playlist) {
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist is cannot be null.");
        }
        this.playlist = playlist;
    }

    public Playlist findByLengthGreaterThan(int min) {
        List<Song> songs = new ArrayList<>(Arrays.asList());

        for (Song song : playlist ) {
            if (song.getLengthInSeconds() / 60 >= min ) {
                songs.add(song);
            }
        }
        return new Playlist(songs);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("Playlist:\n");
        for( Song song: playlist) {
            print.append(song);
            print.append("\n");
        }
        return print.toString();
    }
}
