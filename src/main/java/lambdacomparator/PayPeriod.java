package lambdacomparator;

public enum PayPeriod {

    MONTHLY(1), ANNUAL(12), LIFETIME(Integer.MAX_VALUE);


    private int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
