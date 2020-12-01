package introinheritance.basket;

import java.util.List;

public class ShoppingBasket {

    private Basket basket = new Basket();


    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        List<Item> items = basket.getItems();
        double sum = 0;
        for (Item item:items) {
            sum += item.getNettoPrice();
        }
        return sum;
    }
    public double sumTaxValue() {
        List<Item> items = basket.getItems();
        double sum = 0;
        for (Item item:items) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
        }

    public void checkout() {
        basket.clearBasket();
        }

    public void removeMostExpensiveItem() {
        List<Item> items = basket.getItems();
        double maxPrice = 0;
        String barcode = "";
        for (Item item:items) {
            double price = item.getNettoPrice() + item.getTaxAmount();
            if (price > maxPrice) {
                maxPrice = price;
                barcode = item.getBarcode();
            }
        }
        basket.removeItem(barcode);
    }
}
