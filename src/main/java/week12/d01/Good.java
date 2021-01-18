package week12.d01;

public class Good {

    private final int weight;

    private final int price;

    public Good(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
