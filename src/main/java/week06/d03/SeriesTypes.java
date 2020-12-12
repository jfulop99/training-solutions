package week06.d03;

public enum SeriesTypes {
    DESCENDING_SERIES(-1), ASCENDING_SERIES(1), UNSORTED_SERIES(0);

    private final int factor;

    SeriesTypes(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
}
