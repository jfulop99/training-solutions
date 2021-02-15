package practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CanoeOffice {

    private List<CanoeRental> rentalList;

    public CanoeOffice() {

        rentalList = new ArrayList<>();

    }

    public void addRental(CanoeRental rental) {

        rentalList.add(rental);

    }

    public CanoeRental findRentalByName(String name) {

        for (CanoeRental item : rentalList) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen név");
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {

        findRentalByName(name).setEndTime(endTime);

    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental actual = findRentalByName(name);

        return Duration.between(actual.getStartTime(), endTime).toHours() * actual.getCanoeType().getMultiplier() * 5000D;
    }

    public List<CanoeRental> listClosedRentals() {
        return rentalList.stream()
                .filter(rental -> rental.getEndTime() == null)
                .sorted(Comparator.comparing(CanoeRental::getStartTime))
                .collect(Collectors.toList());
    }

    public Map<CanoeType, Long> countRentals() {

        return rentalList.stream()
                .collect(Collectors.groupingBy(CanoeRental::getCanoeType, Collectors.counting()));
    }

}
