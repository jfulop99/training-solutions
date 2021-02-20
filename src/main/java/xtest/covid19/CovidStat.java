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
            String[] parts = CsvSplitter.split(line, ",");
            if (!parts[9].isBlank()) {
                String country = parts[0];
                int number = Integer.parseInt(parts[5]);
                String indicator = parts[4];
                long population = Long.parseLong(parts[3]);
                String continent = parts[2];

                if (!cases.containsKey(country)) {
                    cases.put(country, new Country(country, 0, population, 0, continent));
                }
                if ("cases".equals(indicator)) {
                    cases.get(country).addCases(number);
                } else if ("deaths".equals(indicator)) {
                    cases.get(country).addDeath(number);
                }
            }
        }

        result = cases.values().stream()
//                .filter(cont -> cont.getContinent().equals("Europe"))
                .sorted(Comparator.comparingDouble(Country::getDeathRate).reversed()).collect(Collectors.toList());
        System.out.println("Halálozás / Népesség");
        for (int i = 0; i < result.size(); i++) {
            if (i < 15) {
                System.out.printf("%2d %7.4f%% %-30s\n", i + 1, result.get(i).getDeathRate() * 100, result.get(i).getName());
            }
            if (result.get(i).getName().equals("Hungary") && i > 14) {
                System.out.printf("%2d %7.4f%% %-30s\n", i + 1, result.get(i).getDeathRate() * 100, result.get(i).getName());
                break;
            }
        }

        result = cases.values().stream()
//                .filter(cont -> cont.getContinent().equals("Europe"))
                .sorted(Comparator.comparingDouble(Country::getRate).reversed()).collect(Collectors.toList());
        System.out.println("Esetszám / Népesség");
        for (int i = 0; i < result.size(); i++) {
            if (i < 15) {
                System.out.printf("%2d %7.4f%% %-30s\n", i + 1, result.get(i).getRate() * 100, result.get(i).getName());
            }
            if (result.get(i).getName().equals("Hungary") && i > 14) {
                System.out.printf("%2d %7.4f%% %-30s\n", i + 1, result.get(i).getRate() * 100, result.get(i).getName());
                break;
            }
        }

        return result.subList(0, 3);

    }

    public static void main(String[] args) throws IOException {

        CovidStat covidStatistic = new CovidStat();
        URL url = new URL("https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/csv/data.csv");
        URLConnection connection = url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            System.out.println(covidStatistic.maxCasesPerPopulationMap(reader));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }
}
