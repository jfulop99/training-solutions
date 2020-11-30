package week06d01;

public class ResultSeparatedSum {
    private double positiveSum;
    private double negativeSum;

    public ResultSeparatedSum(double positiveSum, double negativeSum) {
        this.positiveSum = positiveSum;
        this.negativeSum = negativeSum;
    }

    public double getPositiveSum() {
        return positiveSum;
    }

    public double getNegativeSum() {
        return negativeSum;
    }
}