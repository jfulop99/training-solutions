package week05d04;

import org.junit.jupiter.api.Test;
import week05d03.UserValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    void testWithNullCurrency() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Product(1000, null));
        assertEquals("Currency must not be null", ex.getMessage());
    }

    @Test
    void testWithHufUsd() {

        Product product = new Product(150, Currency.HUF);
        assertEquals(0.5, product.convertPrice(Currency.USD));
    }

    @Test
    void testWithUsdHuf() {

        Product product = new Product(100, Currency.USD);
        assertEquals(30000, product.convertPrice(Currency.HUF));
    }

    @Test
    void testWithUsdUsd() {

        Product product = new Product(100, Currency.USD);
        assertEquals(100, product.convertPrice(Currency.USD));
    }
    @Test
    void testWithHufHuf() {

        Product product = new Product(100, Currency.HUF);
        assertEquals(100, product.convertPrice(Currency.HUF));
    }


}
