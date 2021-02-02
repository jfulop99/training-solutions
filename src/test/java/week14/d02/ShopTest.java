package week14.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {

    Shop shop;

    @BeforeEach
    void setUp() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Shop.class.getResourceAsStream("shop.txt")))){
            shop = new Shop(reader);
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    @Test
    void getTotalAmountByUser() {

        assertEquals(9650, shop.getTotalAmountByUser("SM123"));

    }

    @Test
    void getOrderedList() {

        assertEquals("chicken", shop.getOrderedList("SM123", "120", OrderType.ORDERING_BY_NAME).get(0).getName());
        assertEquals("tomato", shop.getOrderedList("SM123", "120", OrderType.ORDERING_BY_PRICE).get(0).getName());

    }

    @Test
    void totalAmountOfPurchase() {

        assertEquals(700, shop.totalAmountOfPurchase("112"));

    }

    @Test
    void productStatistic() {

        Map<String, Integer> result = shop.productStatistic();
        assertEquals(3, result.get("bread"));
        assertEquals(2, result.get("salt"));
        assertEquals(1, result.get("Nutella"));

    }

    @Test
    void getNumberOfProductByName() {

        assertEquals(3, shop.getNumberOfProductByName("bread"));
        assertEquals(2, shop.getNumberOfProductByName("salt"));
        assertEquals(1, shop.getNumberOfProductByName("Nutella"));

    }

    @Test
    void getBuyerList() {
        assertEquals("tomato", shop.getBuyerList().get("RA22").get(0).getProducts().get(0).getName());
    }
}