package week14d02;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

    private final String purchaseId;
    private List<Product> products;

    public Purchase(String purchaseId, List<Product> products) {
        this.purchaseId = purchaseId;
        this.products = products;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
