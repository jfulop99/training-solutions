package week13.d02;

public enum Direction {

    ARRIVAL("Arrival"), DEPARTURE("Departure");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
