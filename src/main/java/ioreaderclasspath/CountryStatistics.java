package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(fileName)))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                countries.add(new Country(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public Country mostBorderCountries() {
        int maxBorderCountries = 0;
        Country country = null;
        for (Country item :countries) {
            if (maxBorderCountries < item.getBorderCountries()) {
                maxBorderCountries = item.getBorderCountries();
                country = item;
            }
        }
        return new Country(country.getName(), country.getBorderCountries());
    }
}
