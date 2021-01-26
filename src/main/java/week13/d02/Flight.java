package week13.d02;

import java.util.StringTokenizer;

public class Flight {

    private final String flightNumber;

    private final Direction direction;

    private final String city;

    private final int hours;

    private final int minutes;

    private static final int POS_FLIGHT_NUMBER = 0;
    private static final int POS_DIRECTION = 1;
    private static final int POS_CITY = 2;
    private static final int POS_TIME = 3;
    private static final int POS_HOUR = 0;
    private static final int POS_MINUTES = 1;



    public Flight(String flightNumber, Direction direction, String city, int hours, int minutes) {
        this.flightNumber = flightNumber;
        this.direction = direction;
        this.city = city;
        this.hours = hours;
        this.minutes = minutes;
    }

    public static Flight createFlightFromString(String line) {

        String[] parts = lineTokenizer(line);

        String[] time = parts[POS_TIME].split(":");
        int hours = Integer.parseInt(time[POS_HOUR]);
        int minutes = Integer.parseInt(time[POS_MINUTES]);

        return new Flight(parts[POS_FLIGHT_NUMBER], Direction.valueOf(parts[POS_DIRECTION].toUpperCase()), parts[POS_CITY], hours, minutes);
    }

    private static String[] lineTokenizer(String line) {
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        String[] tokens = new String[4];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            tokens[i] = stringTokenizer.nextToken();
            if (i == 3 && stringTokenizer.hasMoreTokens()) {
                tokens[2] = tokens[2] + " " + tokens[3];
                tokens[3] = stringTokenizer.nextToken();
            }
            i++;
        }
        return tokens;
    }

    @Override
    public String toString() {
        return String.format("%s %-9s %-15s %02d:%02d", flightNumber, direction.getName(), city, hours, minutes);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCity() {
        return city;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
