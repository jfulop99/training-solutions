package exam03;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    private List<Passenger> passengers;

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        if (boat == null || sailing == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
        passengers = new ArrayList<>();
    }

    public void bookPassenger(Passenger passenger) {

        if (passengers.size() == boat.getMaxPassengers()) {
            throw new IllegalArgumentException("No more space");
        }
        passengers.add(passenger);

    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier() * basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot be null or blank");
        }
        for (Passenger item : passengers) {

            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("There is no passenger with name: " + name);
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream()
                .map(Passenger::getName)
                .sorted(Comparator.comparing(Function.identity(), (String::compareTo)))
                .collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {

        double total = 0D;
        for (Passenger item : passengers) {

            total += getPriceForPassenger(item);

        }
        return total;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> countOfClass = new HashMap<>();
        for (Passenger item : passengers) {
            countOfClass.merge(item.getCruiseClass(), 1, Integer::sum);
        }
        return countOfClass;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
