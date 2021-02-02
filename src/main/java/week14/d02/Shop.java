package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    private Map<String, List<Purchase>> buyerList;

    public Shop(BufferedReader reader) throws IOException {

        readDataFromFile(reader);

    }

    public void readDataFromFile(BufferedReader reader) throws IOException {

        buyerList = new HashMap<>();
        String line ;
        while ((line = reader.readLine()) != null) {
            lineParser(line);
        }

    }

    private void lineParser(String line) {
        String[] parts = line.split("[-,]|: ");
        String buyerId = parts[0];

        if (!buyerList.containsKey(buyerId)) {
            buyerList.put(buyerId, new ArrayList<>());
        }

        buyerList.get(buyerId).add(purchaseReader(parts));
    }

    private Purchase purchaseReader(String[] parts) {

        List<Product> productList = new ArrayList<>();
        String purchaseId = parts[1];

        for (int i = 2; i < parts.length ; i++) {
            productList.add(new Product(parts[i]));
        }

        return new Purchase(purchaseId, productList);
    }

    public int getTotalAmountByUser(String buyerId) {
        List<Purchase> purchases = getPurchaseList(buyerId);
        return purchases.stream().mapToInt(Purchase::getAmountOfPurchase).sum();

    }

    private List<Purchase> getPurchaseList(String buyerId) {
        if (buyerId == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        List<Purchase> purchases = buyerList.get(buyerId);
        if (purchases == null) {
            throw new IllegalArgumentException("There is no buyer with this ID");
        }
        return purchases;
    }

    public List<Product> getOrderedList(String buyerId, String purchaseId, OrderType orderType) {

        List<Product> result = getPurchaseList(buyerId).stream().filter(purchase -> purchase.getId().equals(purchaseId))
                .flatMap(p -> p.getProducts().stream()).collect(Collectors.toList());

        if (orderType == OrderType.ORDERING_BY_NAME) {
            result.sort(Comparator.comparing(Product::getName));
        }
        if (orderType == OrderType.ORDERING_BY_PRICE) {
            result.sort(Comparator.comparingInt(Product::getPrice));
        }

        return result;
    }

    public int totalAmountOfPurchase(String purchaseId) {
        if (purchaseId == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        Optional<Purchase> found = buyerList.values().stream().flatMap(Collection::stream)
                .filter(purchase -> purchase.getId().equals(purchaseId)).findAny();

        if (found.isPresent()) {
            return found.get().getAmountOfPurchase();
        }
        throw new IllegalArgumentException("There is no purchase with this ID");
    }

    public Map<String, Integer> productStatistic() {

        List<Product> products = buyerList.values().stream().flatMap(Collection::stream).flatMap(a -> a.getProducts().stream()).collect(Collectors.toList());
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        Map<String, Integer> result = new TreeMap<>(collator);

        for (Product product:products) {
            result.merge(product.getName(), 1, Integer::sum);
        }
        return result;
    }

    public int getNumberOfProductByName(String productName) {
        return productStatistic().get(productName);
    }

    public Map<String, List<Purchase>> getBuyerList() {
        return new HashMap<>(buyerList);
    }

    public static void main(String[] args) {

        Shop shop;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Shop.class.getResourceAsStream("shop.txt")))){
            shop = new Shop(reader);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        System.out.println(shop.getBuyerList());


        System.out.println("1. " + shop.totalAmountOfPurchase("112"));
        System.out.println("2. " + shop.getTotalAmountByUser("SM123"));
        System.out.println("3. (name) " + shop.getOrderedList("SM123", "120", OrderType.ORDERING_BY_NAME));
        System.out.println("3. (price) " + shop.getOrderedList("SM123", "120", OrderType.ORDERING_BY_PRICE));
        System.out.println("4. " + shop.getNumberOfProductByName("bread"));
        System.out.println("5. " + shop.productStatistic());
        System.out.println("5. ");
        shop.productStatistic().entrySet().forEach(System.out::println);
    }
}
