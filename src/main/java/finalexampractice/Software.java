package finalexampractice;

public abstract class Software {

    private String name;

    protected double price;

    public abstract void increasePrice();

    public Software(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
