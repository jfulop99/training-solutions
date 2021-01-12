package week11.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rides = new ArrayList<>();


    public void readFile() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Courier.class.getResourceAsStream("/rides.txt")))) {
            while ((line = br.readLine()) != null) {
                String[] parts= line.split(" ");
                rides.add(new Ride (Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file",e);
        }
    }

    private List<WeekDistances> initList() {
        List<WeekDistances> distances= new ArrayList<>();
        for (int i = 1 ; i<8 ; i++) {
            distances.add(new WeekDistances(i,0));
        }
        return distances;
    }

    public List<WeekDistances> getDistanceByDay() {
        if (rides.size() == 0) {
            readFile();
        }
        List<WeekDistances> distances= initList();
        for (Ride ride : rides) {
            distances.get(ride.getDay() - 1).add(ride.getDistance());
        }
        return new ArrayList<>(distances);
    }

    public Ride getFirstRide() {
        if (rides.size() == 0) {
            readFile();
        }
        int minDay = 8;
        Ride firstRide = null;
        for (Ride ride : rides) {
            if(ride.getDay() <= minDay) {
                minDay = ride.getDay();
                if ( ride.getNo() == 1) {
                    firstRide = ride;
                }
            }
        }
        return firstRide;
    }

    public List<WeekDistances> getMissingDays() {
        if (rides.size() == 0) {
            readFile();
        }
        List<WeekDistances> distances = getDistanceByDay();

        distances.removeIf(item -> item.getDistance() > 0);
        return distances;
    }

    public static void main(String[] args) {

        Courier courier = new Courier();

        courier.readFile();

        System.out.println(courier.getRides().size());
        System.out.println(courier.getFirstRide());
        System.out.println(courier.getDistanceByDay());
        System.out.println(courier.getMissingDays());

    }

    public List<Ride> getRides() {
        return new ArrayList<>(rides);
    }
}
