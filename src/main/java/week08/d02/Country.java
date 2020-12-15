package week08.d02;

public class Country {

    private String name;
    private int populationInMillions;
    private int numberOfColorsOfFlag;
    private int numberOfNeighbors;

    public Country(String name, int populationInMillions, int numberOfColorsOfFlag, int numberOfNeighbors) {
        this.name = name;
        if (populationInMillions < 0) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        this.populationInMillions = populationInMillions;
        if (numberOfColorsOfFlag < 1) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        this.numberOfColorsOfFlag = numberOfColorsOfFlag;
        if (numberOfNeighbors < 0) {
            throw new IllegalArgumentException("Wrong parameter");
        }
        this.numberOfNeighbors = numberOfNeighbors;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", populationInMillions=" + populationInMillions +
                ", numberOfColorsOfFlag=" + numberOfColorsOfFlag +
                ", numberOfNeighbors=" + numberOfNeighbors +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPopulationInMillions() {
        return populationInMillions;
    }

    public int getNumberOfColorsOfFlag() {
        return numberOfColorsOfFlag;
    }

    public int getNumberOfNeighbors() {
        return numberOfNeighbors;
    }
}
