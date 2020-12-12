package week06.d04;

public class Item {

    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        if (isBlankOrNull(name)) {
            throw new IllegalArgumentException("Name must be valid!");
        }
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    private boolean isBlankOrNull(String name) {
        return name == null || name.isBlank();
    }
}
