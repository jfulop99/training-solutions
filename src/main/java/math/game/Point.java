package math.game;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt( (double) Math.pow(Math.abs(other.getX() - x), 2) + (double) Math.pow(Math.abs(other.getY() - y), 2));
    }
}
