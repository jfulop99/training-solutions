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
        int index = findItem(name);
            if (index >= 0) {
                return items.get(index).getQuantity();
            }
        return 0;
    }

    public void addItem(String name, int quantity) {
        if (isBlankOrNull(name)) {
            throw new IllegalArgumentException("Name must be valid!");
        }
        int index = findItem(name);
        if (index < 0) {
            items.add(new Item(name,quantity));
        }
        else {
            items.get(index).addQuantity(quantity);
        }

    }

    private int findItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (name.equals(items.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBlankOrNull(String name) {
        return name == null || name.isBlank();
    }
}
