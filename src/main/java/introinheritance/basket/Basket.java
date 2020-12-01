package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        //items.removeIf(item -> barcode.equals(item.getBarcode()));
        while (findItemByBarcode(barcode)) {}
    }

    public void clearBasket() {
        items.clear();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    private boolean findItemByBarcode(String barcode) {
        int index = 0;
        while (index < items.size()){
            if (barcode.equals(items.get(index).getBarcode())) {
                items.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
}
