package xerettsegi.y2019.oktober;

public enum ReduceRate {

    FULL(0), HALF(50), FREE(100);

    private int rate;

    ReduceRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
