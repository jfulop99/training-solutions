package ioreaderclasspath;

public class Country {

    private String name;
    private int numberOfNeighbors;

    public Country(String name, int numberOfNeighbors) {
        this.name = name;
        this.numberOfNeighbors = numberOfNeighbors;
    }

    public String getName() {
        return name;
    }

    public int getBorderCountries() {
        return numberOfNeighbors;
    }
}
