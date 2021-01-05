package week10.d01;

public class LevelChange {

    private double lifting;
    private double descent;

    public double getLifting() {
        return lifting;
    }

    public double getDescent() {
        return descent;
    }

    public void addDifference(double diff) {
        if (diff < 0 ) {
            descent -= diff;
        }
        else {
            lifting += diff;
        }
    }

    @Override
    public String toString() {
        return "LevelChange{" +
                "lifting=" + lifting +
                ", descent=" + descent +
                '}';
    }
}
