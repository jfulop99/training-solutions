package week06.d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void getProductsByCategory() {

        Store store = null;

        List<Product> products = new ArrayList<>();
        products.add(new Product("Krumpli", CategoryOfProduct.FROZEN, 25.65));
        products.add(new Product("Krumpli", CategoryOfProduct.DAIRY, 25.65));
        products.add(new Product("Krumpli", CategoryOfProduct.DAIRY, 25.65));
        products.add(new Product("Krumpli", CategoryOfProduct.FROZEN, 25.65));
        products.add(new Product("Krumpli", CategoryOfProduct.FROZEN, 25.65));
        products.add(new Product("Krumpli", CategoryOfProduct.BAKEDGOODS, 25.65));

        store = new Store(products);

        assertEquals(3, store.getProductsByCategory().get(0).getNumber());
        assertEquals(2, store.getProductsByCategory().get(1).getNumber());
        assertEquals(1, store.getProductsByCategory().get(2).getNumber());
    }
}