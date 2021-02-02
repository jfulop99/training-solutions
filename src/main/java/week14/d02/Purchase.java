package week14.d02;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private final String id;

    private final List<Product> products;


    public Purchase(String id, List<Product> products) {
        this.id = id;
        this.products = new ArrayList<>(products);
    }


    public int getAmountOfPurchase() {

        return products.stream().map(Product::getPrice).reduce(0, Integer::sum);

    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        return id + ", " + products;
    }
}
