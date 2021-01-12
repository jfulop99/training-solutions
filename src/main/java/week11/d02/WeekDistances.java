package week11.d02;

public class WeekDistances {

    private int day;
    private int distance;
    public WeekDistances(int day) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Day maust be between 1 - 7");
        }
        this.day = day;
        distance = 0;
    }
    public WeekDistances(int day, int distance) {
        this.day = day;
        this.distance = distance;
    }
    public void add(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
        this.distance += distance;
    }

    public int getDay() {
        return day;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "WeekDistances{" +
                "day=" + day +
                ", distance=" + distance +
                '}';
    }
}
