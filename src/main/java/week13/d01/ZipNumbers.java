package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;

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

    public ZipNumber getFirstCityByName() {

        List<ZipNumber> sorted = new ArrayList<>(zipNumberList);



        ZipNumber result;

//        result = sorted.stream().min(Comparator.comparing(ZipNumber::getName).thenComparing(ZipNumber::getDistrict)).get();

        Collator collator = Collator.getInstance(new Locale("hu", "HU"));

        RuleBasedCollator ruleBasedCollator = null;

        try {
             ruleBasedCollator = new RuleBasedCollator("< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS \n" +
                    " < e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J\n" +
                    " < k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó \n" +
                    " < ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T \n" +
                    " < ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        collator.setStrength(Collator.IDENTICAL);

        Collections.sort(sorted, Comparator.comparing(ZipNumber::getName, Comparator.nullsLast(ruleBasedCollator)).thenComparing(ZipNumber::getDistrict, Comparator.nullsFirst(collator)));

        sorted.forEach(System.out::println);

        result = sorted.get(0);

        return result;

    }
    public static void main(String[] args) {
        ZipNumbers zipNumbers = new ZipNumbers();

        System.out.println(zipNumbers.getFirstCityByName().getName());


    }
}
