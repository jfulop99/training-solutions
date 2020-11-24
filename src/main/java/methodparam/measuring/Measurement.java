package methodparam.measuring;

public class Measurement {

    private double[] results;

    public Measurement(double[] results) {
        this.results = results;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i =0; i < results.length; i++) {
            if (results[i] > lower && results[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double minimum = Double.MAX_VALUE;
        for (double result: results ) {
            if (result < minimum) {
                minimum = result;
            }
        }
        return minimum;
    }

    public double maximum() {
        double maximum = Double.MIN_VALUE;
        for (double result: results ) {
            if (result > maximum) {
                maximum = result;
            }
        }
        return maximum;
    }

    public ExtremValues minmax() {
        return new ExtremValues(minimum(), maximum());
    }


}
