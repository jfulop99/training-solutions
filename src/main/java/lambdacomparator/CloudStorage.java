package lambdacomparator;

public class CloudStorage implements Comparable<CloudStorage>{

    private String provider;

    private int space;

    private PayPeriod period;

    private double price;


    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this.provider = provider;
        this.space = space;
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
//        this.period = PayPeriod.LIFETIME;
        this.price = 0.0;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double thisRate = 0.0;
        double otherRate = 0.0;

        if (this.period != null) {
            thisRate = price * 12 / period.getLength() / space * 1000;
        }
        if (o.period != null) {
            otherRate = o.price * 12 / o.period.getLength() / o.space * 1000;
        }

        return (int) (thisRate - otherRate);
    }

    @Override
    public String toString() {
        return "CloudStorage{" +
                "provider='" + provider + '\'' +
                ", space=" + space +
                ", period=" + period +
                ", price=" + price +
                '}';
    }
}
