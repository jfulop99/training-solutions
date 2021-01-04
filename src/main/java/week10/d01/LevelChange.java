package week10.d01;

public class LevelChange {

    private final double lifting;
    private final double descent;

    public LevelChange(double lifting, double descent) {
        this.lifting = lifting;
        this.descent = descent;
    }

    public double getLifting() {
        return lifting;
    }

    public double getDescent() {
        return descent;
    }

    @Override
    public String toString() {
        return "LevelChange{" +
                "lifting=" + lifting +
                ", descent=" + descent +
                '}';
    }
}
