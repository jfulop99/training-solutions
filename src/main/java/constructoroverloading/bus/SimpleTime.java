package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;


    public SimpleTime(int hours, int minutes) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0-23");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes must be between 0-59");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Hours must be between 0-23");
        }
        this.hours = hours;
    }

    public SimpleTime(SimpleTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Time must not be null");
        }
        hours = time.getHours();
        minutes = time.getMinutes();
    }

    public int difference(SimpleTime time) {
        if (time == null) {
            throw new IllegalArgumentException("Time must not be null");
        }
        int difference;
        difference = (hours * 60 + minutes) - (time.getHours() * 60 + time.getMinutes());
        return difference;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
