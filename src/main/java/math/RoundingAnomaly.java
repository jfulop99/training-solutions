package math;

import java.lang.reflect.Array;
import java.util.Random;

public class RoundingAnomaly {
    private double randomNumbers [];
    private final Random random = new Random();


    public double[] randomNumbers(int size, double max, int scale){
        randomNumbers = new double[size];
        for (double elem : randomNumbers) {
            elem = random.nextDouble() * 1000000;
        }
        return randomNumbers;
    }

    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        roundingAnomaly.randomNumbers(100, 1000000.0, 5);

    }

}
