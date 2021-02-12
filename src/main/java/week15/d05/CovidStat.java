package week15.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CovidStat {

    public List<Country> maxCasesPerPopulation(Path path) {

        List<Country> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            readHeader(reader);
            String line;
            String prevCountry = "Sehol";
            Country temp = null;
            while ((line = reader.readLine()) != null) {
                line = line.replace("Bonaire,", "Bonaire");
                String[] parts = line.split(",");
                if (!parts[7].isBlank()) {
                    if (!parts[4].equals(prevCountry)) {
                        if (temp != null) {
                            result.add(temp);
                        }
                        temp = new Country(parts[4], Integer.parseInt(parts[2]), Integer.parseInt(parts[7]));
                        prevCountry = parts[4];
                    } else {
                        temp.addCases(Integer.parseInt(parts[2]));
                    }
                }
            }
            result.add(temp);


        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        result.sort((o1, o2) -> Double.compare(o2.getRate(), o1.getRate()));

        return result.subList(0, 3);
    }

    public void readHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }


    public List<Country> maxCasesPerPopulationMap(Path path) {

        List<Country> result;
        Map<String, Country> cases = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            readHeader(reader);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replace("Bonaire,", "Bonaire");
                String[] parts = line.split(",");
                if (!parts[7].isBlank()) {
                    String country = parts[4];
                    int number = Integer.parseInt(parts[2]);
                    int population = Integer.parseInt(parts[7]);

                    if (!cases.containsKey(country)) {
                        cases.put(country, new Country(country, number, population));
                    } else {
                        cases.get(country).addCases(number);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        result = new ArrayList<>(cases.values());
        result.sort(Comparator.comparingDouble(Country::getRate).reversed());

        return result.subList(0, 3);

    }

    private Country parse(String s) {
        String[] parts = s.split(",");
        if (!parts[7].isBlank()) {
            String country = parts[4];
            int number = Integer.parseInt(parts[2]);
            int population = Integer.parseInt(parts[7]);
            return new Country(country, number, population);
        } else {
            return new Country(null, 0, 0);
        }
    }

    public List<Country> maxCasesPerPopulationStream(Path path) {
        List<Country> result;
        Map<String, Country> cases = new HashMap<>();

        try (Stream<String> lines = Files.lines(path)) {
            cases = lines
                    .skip(1)
                    .map(s -> s.replace("Bonaire,", "Bonaire"))
                    .map(this::parse)
                    .filter(c -> c.getName() != null)
                    .collect(Collectors.toMap(
                            Country::getName,
                            Function.identity(),
                            Country::add));


        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }


        return cases.values().stream().sorted(Comparator.comparingDouble(Country::getRate).reversed()).limit(3).collect(Collectors.toList());
    }


    public static void main(String[] args) {

        CovidStat covidStatistic = new CovidStat();

        System.out.println(covidStatistic.maxCasesPerPopulation(Path.of("data.csv")));
        System.out.println(covidStatistic.maxCasesPerPopulationMap(Path.of("data.csv")));
        System.out.println(covidStatistic.maxCasesPerPopulationStream(Path.of("data.csv")));
    }

}
