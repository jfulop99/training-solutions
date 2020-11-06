package math;

import java.util.Random;

public class RoundingAnomaly {
    private double[] randomNumbers;
    private Random random = new Random();


    public double[] randomNumbers(int size, double max, int scale){
        randomNumbers = new double[size];
        for (int i = 0; i < size; i++){
            randomNumbers [i] = Math.round(random.nextDouble() * max * Math.pow(10, scale)) / Math.pow(10, scale);
        }
        return randomNumbers;
    }

    public double roundAfterSum(double[] randomNumbers){
        double sum = 0.0;
        for (double number:randomNumbers) {
            sum += number;
        }
        return Math.round(sum);
    }

    public double sumAfterRound(double[] randomNumbers){
        double sum = 0.0;
        for (double number:randomNumbers) {
            sum += Math.round(number);
        }
        return sum;
    }

    public double difference(int size, double max, int scale){
        double[] randomArray;
        randomArray = randomNumbers(size, max, scale);
        return Math.abs(roundAfterSum(randomNumbers) - sumAfterRound(randomNumbers));
    }


    public static void main(String[] args) {

        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double sum = 0.0;
        for (int i = 0; i < 100; i++) {
            double difference = roundingAnomaly.difference(1000, 1000000, 5);
            sum += difference;
            System.out.println("Difference: " + difference);
        }
        System.out.println("Mean difference: " + sum / 100);
    }

}
