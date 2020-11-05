package math;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class RoundingAnomaly {
    private double randomNumbers [];
    private final Random random = new Random();


    public double[] randomNumbers(int size, double max, int scale){
        randomNumbers = new double[size];
        for (int i = 0; i < size; i++){
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setRoundingMode(RoundingMode.CEILING);
            randomNumbers [i] = random.nextDouble() * 1000000.0;


        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        roundingAnomaly.randomNumbers(100, 1000000.0, 5);
    }

}
