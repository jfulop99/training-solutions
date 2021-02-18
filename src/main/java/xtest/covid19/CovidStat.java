package xtest.covid19;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CovidStat {

    public List<Country> maxCasesPerPopulationMap(BufferedReader reader) throws IOException {

        List<Country> result;
        Map<String, Country> cases = new HashMap<>();


        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
//                line = line.replace("Bonaire,", "Bonaire");
//                String[] parts = line.split(",");
            String[] parts = CsvSplitter.split(line, ",");
            if (!parts[9].isBlank()) {
                String country = parts[6];
                int number = Integer.parseInt(parts[4]);
                int numberOfDeaths = Integer.parseInt(parts[5]);
                int population = Integer.parseInt(parts[9]);
                String continent = parts[10];

                if (!cases.containsKey(country)) {
                    cases.put(country, new Country(country, number, population, numberOfDeaths, continent));
                } else {
                    cases.get(country).addCases(number);
                    cases.get(country).addDeath(numberOfDeaths);
                }
            }
        }

        result = cases.values().stream()
                .filter(cont -> cont.getContinent().equals("Europe"))
                .sorted(Comparator.comparingDouble(Country::getDeathRate).reversed()).collect(Collectors.toList());
        System.out.println("Deaths/Population");
        for (int i = 0; i < result.size(); i++) {
            if (i < 15) {
                System.out.println(i + 1 + "\t" + result.get(i).getName());
            }
            if (result.get(i).getName().equals("Hungary")) {
                System.out.println(i + 1 + "\t" + result.get(i).getName());
                break;
            }
        }

        result = cases.values().stream()
                .filter(cont -> cont.getContinent().equals("Europe"))
                .sorted(Comparator.comparingDouble(Country::getRate).reversed()).collect(Collectors.toList());
        System.out.println("Cases/Population");
        for (int i = 0; i < result.size(); i++) {
            if (i < 15) {
                System.out.println(i + 1 + " " + result.get(i).getName());
            }
            if (result.get(i).getName().equals("Hungary")) {
                System.out.println(i + 1 + " " + result.get(i).getName());
                break;
            }
        }

        return result.subList(0, 3);

    }

    public static void main(String[] args) throws IOException {

        CovidStat covidStatistic = new CovidStat();
        URL url = new URL("https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv");
        URLConnection connection = url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            System.out.println(covidStatistic.maxCasesPerPopulationMap(reader));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }


}
