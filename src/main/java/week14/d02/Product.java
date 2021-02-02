package week14.d02;

public class Product {

    private final String name;

    private final int price;

    public Product(String product) {

        String[] parts = product.split("[()]");

        name = parts[0];

        price = Integer.parseInt(parts[1]);

    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "(" + price + ")";
    }
}
