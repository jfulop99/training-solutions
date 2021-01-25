package week13.d01.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cities {

    private final static String HUNGARIAN_COLLATOR_RULE =   "< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
                                                            " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
                                                            " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
                                                            " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
                                                            " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS";

    private List<City> cityList;

    public Cities(BufferedReader reader) {

        cityList = new ArrayList<>();

        readDataFromFile(reader);

    }

    private void readDataFromFile(BufferedReader reader) {

        try (reader) {

            String line = readHeader(reader);

            while ((line = reader.readLine()) != null) {

                cityList.add(City.generateFromCsv(line));

            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("Cannot find file", npe);
        }


    }

    private String readHeader(BufferedReader reader) throws IOException {

        return reader.readLine();

    }

    City getFirstCityByName() {

        List<City> result = new ArrayList<>(cityList);


        RuleBasedCollator hunRuleBasedCollator = hungarianRuleBasedCollator();

        Collections.sort(result, Comparator.comparing(City::getName, Comparator.nullsLast(hunRuleBasedCollator))
                            .thenComparing(City::getDistrictName, Comparator.nullsFirst(hunRuleBasedCollator)));

//        Collections.sort(result, new ComparateByNameAndDistrict());

        result.forEach(System.out::println);


        return result.get(0);
    }

    private RuleBasedCollator hungarianRuleBasedCollator () {

        RuleBasedCollator ruleBasedCollator = null;

        try {
            ruleBasedCollator = new RuleBasedCollator(HUNGARIAN_COLLATOR_RULE);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Wrong collator rule");
        }

        return ruleBasedCollator;
    }

    public static void main(String[] args) {

        Cities cities = new Cities(new BufferedReader(new InputStreamReader(Cities.class.getResourceAsStream("/iranyitoszamok-varosok-2021.csv"))));
        System.out.println(cities.getFirstCityByName());

    }

}
