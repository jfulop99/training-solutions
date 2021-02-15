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
        Duration duration = Duration.between(actual.getStartTime(), endTime);
        int minutes = duration.toMinutesPart();
        int hours = duration.toHoursPart();
        if (minutes > 0) {
            hours++;
        }
        return hours * actual.getCanoeType().getMultiplier() * 5000D;
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

    public static void main(String[] args) {
        CanoeOffice canoeOffice = new CanoeOffice();

        canoeOffice.addRental(new CanoeRental("Kovács Pista", CanoeType.RED, LocalDateTime.of(2021, 02, 15, 10, 5)));
        canoeOffice.addRental(new CanoeRental("Kovács Béla", CanoeType.RED, LocalDateTime.of(2021, 02, 15, 10, 10)));
        canoeOffice.addRental(new CanoeRental("Kovács Géza", CanoeType.BLUE, LocalDateTime.of(2021, 02, 15, 10, 20)));
        canoeOffice.addRental(new CanoeRental("Kovács Gyula", CanoeType.GREEN, LocalDateTime.of(2021, 02, 15, 10, 30)));

        System.out.println(canoeOffice.findRentalByName("Kovács Gyula"));

        System.out.println(canoeOffice.listClosedRentals());

        canoeOffice.closeRentalByName("Kovács Béla", LocalDateTime.of(2021, 02, 15, 12, 0));

        System.out.println(canoeOffice.listClosedRentals());

        System.out.println(canoeOffice.countRentals());

        System.out.println(canoeOffice.getRentalPriceByName("Kovács Géza", LocalDateTime.of(2021, 2, 15, 11, 30)));

    }

}
