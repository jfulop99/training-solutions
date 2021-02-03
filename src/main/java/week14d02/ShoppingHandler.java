package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;
import java.util.function.Function;

public class ShoppingHandler {

    private Map<String, List<Purchase>> buyers = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException {
        String line = "";
        while ((line = reader.readLine()) != null) {
            parseLine(line);
        }
    }

    private void parseLine(String line) {
        String[] parts = line.split("-|: |,");
        String buyerId = parts[0];
        String purchaseId = parts[1];
        List<Product> products = productsMaker(parts);
        List<Purchase> purchases = new ArrayList<>();
        Purchase newPurchase = new Purchase(purchaseId, products);
        if (!buyers.containsKey(buyerId)) {
            purchases.add(newPurchase);
            buyers.put(buyerId, purchases);
        } else {
            buyers.get(buyerId).add(newPurchase);
        }
    }

    private List<Product> productsMaker(String[] parts) {
        List<Product> products = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
            String name = parts[i].substring(0, parts[i].indexOf("("));
            int price = Integer.parseInt(parts[i].substring(parts[i].indexOf("(") + 1, parts[i].length() - 1));
            products.add(new Product(name, price));
        }
        return products;
    }

    public int priceOfPurchase(String purchaseId) {
        int result = 0;
        for (String buyer : buyers.keySet()) {
            for (Purchase purchase : buyers.get(buyer)) {
                if (purchase.getPurchaseId().equals(purchaseId)) {
                    return spendingOnOnePurchase(purchase);
                }
            }
        }
        return result;
    }

    public int buyerSpending(String buyerId) {
        int result = 0;
        List<Purchase> purchases = buyers.get(buyerId);
        for (Purchase purchase : purchases) {
            result += spendingOnOnePurchase(purchase);
        }
        return result;
    }

    private int spendingOnOnePurchase(Purchase purchase){
        int result = 0;
        for (Product product : purchase.getProducts()) {
            result += product.getPrice();
        }
        return result;
    }

    public List<Product> productsByAlphabet(String purchaseId, OrderType orderType){
        Purchase purchase = findPurchase(purchaseId);
        List<Product> result = new ArrayList<>(purchase.getProducts());
        if (orderType == OrderType.ORDER_BY_NAME) {
            result.sort(Comparator.comparing(Product::getName));
        }

        if (orderType == OrderType.ORDER_BY_PRICE) {
            result.sort(Comparator.comparing(Product::getPrice));
        }

        return result;
    }

    private Purchase findPurchase(String purchaseId){
        Purchase found = null;
        for (String buyer : buyers.keySet()) {
            for (Purchase purchase : buyers.get(buyer)){
                if (purchase.getPurchaseId().equals(purchaseId)) {
                    found = purchase;
                    return found;
                }
            }
        }
        return found;
    }

    public int numberOfProductsByName(String productName) {
        return productStatistic().get(productName);
    }

    public Map<String, Integer> productStatistic() {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        Map<String, Integer> result = new TreeMap<>(collator);
        for (List<Purchase> purchaseList : buyers.values()) {
            for (Purchase purchase : purchaseList) {
                for (Product product : purchase.getProducts()) {
                    String key = product.getName();
                    if (!result.containsKey(key)) {
                        result.put(key, 0);
                    }
                    result.put(key, result.get(key) + 1);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ShoppingHandler shoppingHandler = new ShoppingHandler();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ShoppingHandler.class.getResourceAsStream("shopping.txt")))) {
            shoppingHandler.readFromFile(reader);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file");
        }

        System.out.println(shoppingHandler.priceOfPurchase("112"));

        System.out.println(shoppingHandler.buyerSpending("SM123"));

        System.out.println(shoppingHandler.productsByAlphabet("112", OrderType.ORDER_BY_NAME));

        System.out.println(shoppingHandler.productsByAlphabet("112", OrderType.ORDER_BY_PRICE));

        System.out.println(shoppingHandler.numberOfProductsByName("bread"));

        System.out.println(shoppingHandler.productStatistic());

    }

}
