package week12.d02;

public class House implements Comparable<House>{

    private final int houseNumber;
    private final int width;
    private final String colorOfHedge;

    public House(int houseNumber, int width, String colorOfHedge) {
        if (houseNumber < 1) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
        this.houseNumber = houseNumber;

        if (width < 0) {
            throw new IllegalArgumentException("Must be positive");
        }
        this.width = width;

        if (!colorOfHedge.matches("[A-Z]|\\:|#")) {
            throw new IllegalArgumentException("Must be A-Z, :, #");
        }
        this.colorOfHedge = colorOfHedge;

    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getWidth() {
        return width;
    }

    public String getColorOfHedge() {
        return colorOfHedge;
    }

    @Override
    public int compareTo(House o) {
        return width - o.getWidth();
    }

    @Override
    public String toString() {
        return "(" + houseNumber + ")" + colorOfHedge.repeat(width);
    }
}
