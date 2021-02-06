package xtest.streamtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cities {

    private static final String HUNGARIAN_COLLATOR_RULE = "<' ' < a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
            " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
            " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
            " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
            " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";

    private final RuleBasedCollator hunRuleBasedCollator = new RuleBasedCollator(HUNGARIAN_COLLATOR_RULE);

    private final List<City> cityList;

    private List<City> cityListStream;

    Map<String, List<City>> cityMap;

    public Cities(BufferedReader reader) throws IOException, ParseException {

        cityList = new ArrayList<>();

        readDataFromFile(reader);

        System.out.println();

    }

    private static String getHungarianFirstLetter(City city) {
        String firstLetter = city.getName().substring(0, 1);
        if ("cCzZ".contains(firstLetter)) {
            if ("sS".contains(city.getName().substring(1, 2))) {
                return city.getName().substring(0, 2);
            }
        }
        if ("sS".contains(firstLetter)) {
            if ("zZ".contains(city.getName().substring(1, 2))) {
                return city.getName().substring(0, 2);
            }
        }
        if ("gGlLnNtT".contains(firstLetter)) {
            if ("yY".contains(city.getName().substring(1, 2))) {
                return city.getName().substring(0, 2);
            }
        }
        return firstLetter;
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


    public void readFile(Path path) {
        try (Stream<String> lines = Files.lines(path, Charset.forName("UTF8"))) {
            cityMap = lines
                    .skip(1)
                    .map(City::generateFromCsv)
                    .collect(Collectors.groupingBy(Cities::getHungarianFirstLetter));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void printCitiesByAlphabetOrder() {

        List<String> keys = new ArrayList<>(cityMap.keySet());
        keys.sort(hunRuleBasedCollator);
        for (String key : keys) {
//            List<City> cities = cityMap.get(key);
//            cities.sort(Comparator.naturalOrder());
            System.out.println(key + " " + cityMap.get(key).stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
        }
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

            result.merge(city.getName().substring(0, 1), new TreeSet<>(List.of(city)), Cities::addNextCity);
            //result.computeIfAbsent(city.getName(), b -> new TreeSet<>()).add(city);


        }
        return result;
    }

    private static TreeSet<City> addNextCity(TreeSet<City> cities, TreeSet<City> cities2) {
        cities.addAll(cities2);
        return cities;
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

        try {
            cities.readFile(Path.of(cities.getClass().getResource("/iranyitoszamok-varosok-2021.csv").toURI()));
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }

        cities.printCitiesByAlphabetOrder();

    }

}
