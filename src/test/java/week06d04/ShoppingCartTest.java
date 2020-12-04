package week06d04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Alma", 10);
        shoppingCart.addItem("Körte",15);
        shoppingCart.addItem("Unicum",5);

    }


    @Test
    void addItemsTest() {

        assertEquals(5, shoppingCart.getItem("Unicum"));
        assertEquals(10, shoppingCart.getItem("Alma"));
        assertEquals(15, shoppingCart.getItem("Körte"));
    }

    @Test
    void addToExistingItemTest() {
        shoppingCart.addItem("Alma", 20);
        assertEquals(30, shoppingCart.getItem("Alma"));
    }

    @Test
    void addNullNameTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem(null, 10));
        assertEquals("Name must be valid!", e.getMessage());
    }

    @Test
    void addEmptyNameTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> shoppingCart.addItem("   ", 10));
        assertEquals("Name must be valid!", e.getMessage());
    }
}