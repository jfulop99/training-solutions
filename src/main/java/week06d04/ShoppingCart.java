package week06d04;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public int getItem(String name) {
        if (isBlankOrNull(name)) {
            throw new IllegalArgumentException("Name must be valid!");
        }
        Item item = findItem(name);
            if (item != null) {
                return item.getQuantity();
            }
        return 0;
    }

    public void addItem(String name, int quantity) {
        if (isBlankOrNull(name)) {
            throw new IllegalArgumentException("Name must be valid!");
        }
        Item item = findItem(name);
        if (item == null) {
            items.add(new Item(name,quantity));
        }
        else {
            item.addQuantity(quantity);
        }

    }

    private Item findItem(String name) {
        for (Item item:items) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    private boolean isBlankOrNull(String name) {
        return name == null || name.isBlank();
    }
}
