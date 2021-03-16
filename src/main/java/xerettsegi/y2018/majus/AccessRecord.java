package xerettsegi.y2018.majus;

import java.time.LocalTime;

public class AccessRecord {

    private final LocalTime time;

    private final int personId;

    private final String direction;

    public AccessRecord(LocalTime time, int personId, String direction) {
        this.time = time;
        this.personId = personId;
        this.direction = direction;
    }

    public AccessRecord(String line) {

        String[] parts = line.split(" ");

        this.time = LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        this.personId = Integer.parseInt(parts[2]);
        this.direction = parts[3];

    }

    public LocalTime getTime() {
        return time;
    }

    public int getPersonId() {
        return personId;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isIn() {
        return direction.equals("be");
    }

    @Override
    public String toString() {
        return "AccessRecord{" +
                "time=" + time +
                ", personId=" + personId +
                ", direction='" + direction + '\'' +
                '}';
    }
}
