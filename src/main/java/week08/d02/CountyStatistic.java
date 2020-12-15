package week08.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountyStatistic {

    private List<Country> countries;


    public CountyStatistic() {
        countries = new ArrayList<>();
    }

    public void readDataFile(String filename) {
        Path file = Path.of(filename);



        try (BufferedReader reader = new BufferedReader(new InputStreamReader (CountyStatistic.class.getResourceAsStream("/" + filename)));) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                countries.add(new Country(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
        }catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public Country maxPopulaton() {
        Country maxpopulation = null;
        for (Country country: countries) {
            if (maxpopulation == null || maxpopulation.getPopulationInMillions() < country.getPopulationInMillions()) {
                maxpopulation = country;
            }
        }
        return maxpopulation;
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public static void main(String[] args) {
        CountyStatistic countyStatistic = new CountyStatistic();
        countyStatistic.readDataFile("countries.txt");
        System.out.println(countyStatistic.getCountries());
        System.out.println(countyStatistic.maxPopulaton());
        System.out.println(countyStatistic.getCountries().size());
        countyStatistic.getCountries().add(new Country("test",1,1,1));
        System.out.println(countyStatistic.getCountries().size());

    }
}

