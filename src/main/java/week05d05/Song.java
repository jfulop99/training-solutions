package week05d05;


public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (isEmptyOrNull(name)) {
            throw new IllegalArgumentException("Name is cannot be null or blank.");
        }
        this.name = name;
        if (lengthInSeconds <= 0) {
            throw new IllegalArgumentException(("Length must be bigger than 0."));
        }
        this.lengthInSeconds = lengthInSeconds;
        if (isEmptyOrNull(artist)) {
            throw new IllegalArgumentException("Artist is cannot be null or blank.");
        }
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("Song: %-30s Length: %2d:%02d Artist: %-20s", name, (int)(lengthInSeconds / 60), (int)(lengthInSeconds % 60), artist);
    }

    private boolean isEmptyOrNull(String string) {
        return (string == null || string.isBlank()) ? true : false;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }
}
