package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Airport {

    private List<Flight> flightList;


    public Airport() {
        flightList = new ArrayList<>();
    }

    public Airport(List<Flight> flightList) {
        this.flightList = new ArrayList<>(flightList);
    }

    public void readDataFromFile(BufferedReader reader) {

        try (reader) {

            readLines(reader);

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        }
    }

    private void readLines(BufferedReader reader) throws IOException {

        String line;

        while ((line = reader.readLine()) != null) {
            flightList.add(Flight.createFlightFromString(line));
        }
    }

    public Direction compareDirectionCount() {

        Direction result = Direction.ARRIVAL;

        long numberOfArrivals = flightList.stream().filter(direction -> direction.getDirection() == Direction.ARRIVAL).count();

        long numberOfDepartures = flightList.stream().filter(direction -> direction.getDirection() == Direction.DEPARTURE).count();

        if (numberOfDepartures > numberOfArrivals) {
            result = Direction.DEPARTURE;
        }

        return result;
    }

    public Flight getFlightByFlightNumber(String flightNumber) {

        for (Flight flight:flightList ) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        throw new IllegalArgumentException("No flight");
    }

    public Flight getFirstDepartureFlight() {
        return flightList.stream().filter(flight -> flight.getDirection() == Direction.DEPARTURE)
                .min(Comparator.comparing(Flight::getHours).thenComparing(Flight::getMinutes)).orElseThrow();
    }

    public List<Flight> listFlightByCityAndDirection(Scanner scanner) {

        System.out.println("Input city: ");
        String cityName = scanner.nextLine();
        System.out.println("Input direction: ");
        String direction = scanner.next();

        return flightList.stream().filter(flight -> flight.getCity().equals(cityName) && flight.getDirection().getName().equals(direction)).collect(Collectors.toList());

    }

    public List<Flight> getFlightList() {
        return new ArrayList<>(flightList);
    }
}
