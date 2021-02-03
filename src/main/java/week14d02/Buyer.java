package week14d02;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private final String buyerId;
    private List<Purchase> purchases;

    public Buyer(String buyerId, List<Purchase> purchases) {
        this.buyerId = buyerId;
        this.purchases = purchases;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public List<Purchase> getPurchases() {
        return new ArrayList<>(purchases);
    }

    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }
}
