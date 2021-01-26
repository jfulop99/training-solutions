package week13.d01.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cities {

    private static final String HUNGARIAN_COLLATOR_RULE =   "<' ' < a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
                                                            " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
                                                            " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
                                                            " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
                                                            " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";

    private final RuleBasedCollator hunRuleBasedCollator = hungarianRuleBasedCollator();

    private List<City> cityList;

    public Cities(BufferedReader reader) {

        cityList = new ArrayList<>();

        readDataFromFile(reader);

    }

    private void readDataFromFile(BufferedReader reader) {

        try (reader) {

            readHeader(reader);

            readLines(reader);

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        }


    }

    private void readLines(BufferedReader reader) throws IOException {

        String line;

        while ((line = reader.readLine()) != null) {

            cityList.add(City.generateFromCsv(line));

        }
    }

    private String readHeader(BufferedReader reader) throws IOException {

        return reader.readLine();

    }

    public City getFirstCityByName() {

        List<City> result = new ArrayList<>(cityList);

        Comparator<City> comparatorByNameThenDistrict = Comparator.comparing(City::getName, hunRuleBasedCollator)
                .thenComparing(City::getDistrictName,Comparator.nullsFirst(hunRuleBasedCollator));

        result.sort(comparatorByNameThenDistrict);

        return result.get(0);
    }

    public City getFirstCityByNameWithComparatorClass() {

        List<City> result = new ArrayList<>(cityList);

        result.sort(new ComparateByNameThenDistrict());

        return result.get(0);
    }

    public City getFirstCityByNameWithStream() {

        List<City> result;


        result = cityList.stream().sorted(Comparator.comparing(City::getName, hunRuleBasedCollator)
                .thenComparing(City::getDistrictName, Comparator.nullsFirst(hunRuleBasedCollator))).collect(Collectors.toList());

        return result.get(0);
    }

    public void printCityByNameThenDistrict() {

        List<City> result;

        result = cityList.stream().sorted(Comparator.comparing(City::getName, hunRuleBasedCollator)
                .thenComparing(City::getDistrictName, Comparator.nullsFirst(hunRuleBasedCollator))).collect(Collectors.toList());

        result.forEach(System.out::println);

    }

    City getFirstCityByNameWithStreamMin() {

        Optional<City> result;

        result = cityList.stream().min(Comparator.comparing(City::getName, hunRuleBasedCollator)
                .thenComparing(City::getDistrictName, Comparator.nullsFirst(hunRuleBasedCollator)));

        return result.orElse(null);
    }

    private RuleBasedCollator hungarianRuleBasedCollator () {

        RuleBasedCollator ruleBasedCollator;

        try {
            ruleBasedCollator = new RuleBasedCollator(HUNGARIAN_COLLATOR_RULE);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong collator rule");
        }

        return ruleBasedCollator;
    }

    public static void main(String[] args) {

        Cities cities = new Cities(new BufferedReader(new InputStreamReader(Cities.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv"))));

        cities.printCityByNameThenDistrict();

        System.out.println(cities.getFirstCityByName());

        System.out.println(cities.getFirstCityByNameWithComparatorClass());

        System.out.println(cities.getFirstCityByNameWithStream());

        System.out.println(cities.getFirstCityByNameWithStreamMin());
    }

}
