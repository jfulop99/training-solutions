package xerettsegi.y2018.majus;

public class Result {

    private final int minutes;

    private final boolean in;

    public Result(int minutes, boolean in) {
        this.minutes = minutes;
        this.in = in;
    }

    public boolean isIn() {
        return in;
    }

    public int getMinutes() {
        return minutes;
    }
}
