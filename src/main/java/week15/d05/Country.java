package week15.d05;

public class Country {

    private String name;

    private int cases;

    private int population;

    public Country(String name, int cases, int population) {
        this.name = name;
        this.cases = cases;
        this.population = population;
    }

    public void addCases(int cases) {
        this.cases = this.cases + cases;
    }

    public String getName() {
        return name;
    }

    public int getCases() {
        return cases;
    }

    public int getPopulation() {
        return population;
    }

    public double getRate() {
        return ((double) cases) / population;
    }

    public Country add(Country country) {
        return new Country(name, this.cases + country.cases, population);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", cases=" + cases +
                ", population=" + population +
                '}';
    }
}
