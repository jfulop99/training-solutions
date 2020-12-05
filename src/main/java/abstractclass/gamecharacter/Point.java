package abstractclass.gamecharacter;

public class Point {

    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
       return Math.floor(Math.sqrt(Math.pow(Math.abs(x - point.getX()), 2) + Math.pow(Math.abs(y - point.getY()), 2)));
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
