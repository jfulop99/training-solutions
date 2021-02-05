package xtest.streamtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.stream.Collectors;

public class Cities {

    private static final String HUNGARIAN_COLLATOR_RULE = "<' ' < a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
            " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
            " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
            " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
            " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";

    private final RuleBasedCollator hunRuleBasedCollator = new RuleBasedCollator(HUNGARIAN_COLLATOR_RULE);

    private final List<City> cityList;

    public Cities(BufferedReader reader) throws IOException, ParseException {

        cityList = new ArrayList<>();

        readDataFromFile(reader);

    }

    private void readDataFromFile(BufferedReader reader) throws IOException {

        readHeaderLine(reader);

        readDataLines(reader);

    }

    private void readDataLines(BufferedReader reader) throws IOException {

        String line;

        while ((line = reader.readLine()) != null) {

            cityList.add(City.generateFromCsv(line));

        }
    }

    private String readHeaderLine(BufferedReader reader) throws IOException {

        return reader.readLine();

    }


    public long getNumberOfCities() {

        return cityList.stream()
                .map(City::getName)
                .distinct()
                .count();
    }

    public List<City> getCityListOrderedByName() {
        return cityList.stream()
                .sorted((Comparator.comparing(City::getName, hunRuleBasedCollator)
                        .thenComparing(City::getDistrictName, Comparator.nullsFirst(hunRuleBasedCollator))))
                .collect(Collectors.toList());
    }

    public Map<String, TreeSet<City>> citiesByAToZ() {

        Map<String, TreeSet<City>> result = new TreeMap<>(hunRuleBasedCollator);

        for (City city : cityList) {

            result.computeIfAbsent(city.getName().substring(0, 1), b -> new TreeSet<>()).add(city);


        }
        return result;
    }


    public static void main(String[] args) {

        Cities cities;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Cities.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv")))) {

            cities = new Cities(reader);

        } catch (IOException | NullPointerException | ParseException e) {
            throw new IllegalStateException("Cannot read file");
        }

        System.out.println(cities.getNumberOfCities());

        //cities.getCityListOrderedByName().forEach(System.out::println);

        Map<String, TreeSet<City>> e = cities.citiesByAToZ();
        for (String key : e.keySet()) {
            System.out.print(key + " ");
            System.out.println(e.get(key).stream().map(City::getName).collect(Collectors.joining(" ")));
        }
        System.out.println(cities.citiesByAToZ());

    }

}
