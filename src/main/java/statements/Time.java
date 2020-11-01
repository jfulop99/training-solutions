package statements;

public class Time {
    int hour;
    int min;
    int sec;

    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getInMinutes() {
        return (hour * 60 + min);
    }

    public int getInSeconds() {
        return (hour * 3600 + min * 60 + sec);
    }

    public boolean earlierThan(Time time) {
        return (time.getInSeconds() > this.getInSeconds());
    }


    @Override
    public String toString() {
        return hour + ":" + min + ":" + sec;
    }

}
