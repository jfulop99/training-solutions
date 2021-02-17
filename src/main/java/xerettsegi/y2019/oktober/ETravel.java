package xerettsegi.y2019.oktober;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ETravel {

    private Map<Integer, List<Travel>> travelMap;

    public ETravel() {
        travelMap = new TreeMap<>();
    }

    public void readData(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            Travel travel = new Travel(line);
            travelMap.computeIfAbsent(travel.getStopId(), t -> new ArrayList<>()).add(travel);
        }
    }

    public void printTotalPassengers() {

        System.out.println("2. feladat");
        int totalPassengers = (int) travelMap
                .values()
                .stream()
                .mapToInt(List::size)
                .sum();
        System.out.println("A buszra " + totalPassengers + " utas akart felszállni.");
    }

    public void printTotalRejectedPassengers() {

        System.out.println("3. feladat");
        int totalPassengers = (int) travelMap
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(travel -> !travel.isValid())
                .count();
        System.out.println("A buszra " + totalPassengers + " utas nem szállhatott fel.");
    }

    public void printMaxPassengersAtStop() {
        System.out.println("4. feladat");

        Optional<Map.Entry<Integer, List<Travel>>> maxPassengers = travelMap
                .entrySet()
                .stream()
                .max(Comparator.comparing(a -> a.getValue().size()));
        int stop = maxPassengers.get().getKey();
        int passengers = maxPassengers.get().getValue().size();

        System.out.println("A legtöbb utas (" + passengers + ") a " + stop + ". megállóban próbált felszállni.");
    }

    public void printFreePassengers() {
        System.out.println("5. feladat");
        int freePassengers = (int) travelMap.values()
                .stream()
                .flatMap(List::stream)
                .map(Travel::getTicketType)
                .filter(free -> free.getReduceRate() == ReduceRate.FREE)
                .count();


        System.out.println("Ingyenesen utazók száma: " + freePassengers + " fő");
    }

    public void printDiscountPassengers() {
        int discountPassengers = (int) travelMap.values()
                .stream()
                .flatMap(List::stream)
                .filter(Travel::isValid)
                .map(Travel::getTicketType)
                .filter(free -> free.getReduceRate() == ReduceRate.HALF)
                .count();


        System.out.println("Kedvezményesen utazók száma: " + discountPassengers + " fő");
    }

    public void writeWarningData() {
        System.out.println("7. feladat");

        List<Travel> warningList = travelMap.values().stream()
                .flatMap(List::stream)
                .filter(Travel::isWarning)
                .collect(Collectors.toList());

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("temp/figyelmeztetes.txt"))) {

            for (Travel item : warningList) {

                writer.write(item.getTicketId() + " " + dateFormatter(item.getValid()) + "\n");

            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }

        System.out.println("figyelmeztetes.txt file elkészült");
    }

    private String dateFormatter(String valid) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.parse(valid, format).toString();
    }

    public Map<Integer, List<Travel>> getTravelMap() {
        return travelMap;
    }

    public static void main(String[] args) {

        ETravel eTravel = new ETravel();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ETravel.class.getResourceAsStream("/erettsegi/2019/oktober/4_eUtazas/utasadat.txt")))) {
            eTravel.readData(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        System.out.println(eTravel.getTravelMap());
        eTravel.printTotalPassengers();
        eTravel.printTotalRejectedPassengers();
        eTravel.printMaxPassengersAtStop();
        eTravel.printFreePassengers();
        eTravel.printDiscountPassengers();
        eTravel.writeWarningData();

    }
}
