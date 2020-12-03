package inheritanceattributes.order;

import inheritanceattributes.book.Book;

public class ShippedBook extends Book {

    private int shippingCoast;

    public ShippedBook(String title, int price, int shippingCoast) {
        super(title, price);
        this.shippingCoast = shippingCoast;
    }

    public int order(int pieces) {
        return price * pieces + shippingCoast;
    }

    @Override
    public String toString() {
        return getTitle() + ":" + price + " - " + shippingCoast;
    }
}
