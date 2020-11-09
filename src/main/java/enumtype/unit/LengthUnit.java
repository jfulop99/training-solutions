package enumtype.unit;

public enum LengthUnit {
    MM(true, 1), CM(true, 10), M(true, 1000), YARD(false, 914.4), FOOT(false, 304.8), INCH(false, 25.4);
    private final boolean isSi;
    private final double factor;

    LengthUnit(boolean isSi, double factor) {
        this.isSi = isSi;
        this.factor = factor;
    }

    public boolean isSi() {
        return isSi;
    }

    public double getFactor() {
        return factor;
    }
}
