package week06d01;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SeparatedSum {


    public ResultSeparatedSum sum(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Input list is null or blank");
        }
        Scanner sc = new Scanner(s).useDelimiter(";").useLocale(new Locale("hu", "HU"));
        double positiveSum = 0;
        double negativeSum = 0;
        double input = 0;
        while (sc.hasNext()) {
            try {
                input = sc.nextDouble();
            }catch (InputMismatchException e){
                throw new IllegalArgumentException("There is an error in input string!");
            }
            if (input > 0) {
                positiveSum += input;
            }
            else {
                negativeSum += input;
            }
        }
        return new ResultSeparatedSum(positiveSum,negativeSum);
    }
}
