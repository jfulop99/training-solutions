package week11.d02;

public class Ride {

    private final int day;
    private final int no;
    private final int distance;

    public Ride(int day, int no, int distance) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Day maust be between 1 - 7");
        }
        this.day = day;
        if (distance < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        this.no = no;
        if (distance < 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
        this.distance = distance;
    }

    public int getDay() {
        return day;
    }

    public int getNo() {
        return no;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "day=" + day +
                ", no=" + no +
                ", distance=" + distance +
                '}';
    }
}
