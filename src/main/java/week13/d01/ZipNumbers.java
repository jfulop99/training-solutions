package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ZipNumbers {


    private List<ZipNumber> zipNumberList;

    public ZipNumbers() {

        zipNumberList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ZipNumbers.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")))) {

            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String district = null;
                String[] parts = line.split(";");
                if (parts.length > 2) {
                    district = parts[2];
                }
                zipNumberList.add(new ZipNumber(parts[1], district, parts[0]));
            }


        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        }

    }

    public Optional<ZipNumber> getFirstCityByName() {

        List<ZipNumber> sorted = new ArrayList<>(zipNumberList);

        return sorted.stream().min(Comparator.comparing(ZipNumber::getName).thenComparing(ZipNumber::getDistrict));

    }
    public static void main(String[] args) {
        ZipNumbers zipNumbers = new ZipNumbers();

        System.out.println(zipNumbers.getFirstCityByName().get().getName());


    }
}
