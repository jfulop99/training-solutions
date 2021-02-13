package xerettsegi.y2020.oktober;

public class Episode {

    private String date;
    private String title;
    private String episode;
    private int duration;
    private int watched;

    public Episode(String date, String title, String episode, int duration, int watched) {
        this.date = date;
        this.title = title;
        this.episode = episode;
        this.duration = duration;
        this.watched = watched;
    }

    @Override
    public String toString() {
        return episode + "\t" + title;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisode() {
        return episode;
    }

    public int getDuration() {
        return duration;
    }

    public int getWatched() {
        return watched;
    }
}
