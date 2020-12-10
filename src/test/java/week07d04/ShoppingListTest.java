package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    @Test
    void sumTest() {
        ShoppingList shoppingList = new ShoppingList();
        assertEquals(605,shoppingList.CalculateSum("c:\\Training\\training-solutions\\src\\main\\resources\\list.txt"));
    }

    @Test
    void wrongFileNameTest() {
        ShoppingList shoppingList = new ShoppingList();
        Exception e = assertThrows( IllegalArgumentException.class, () -> shoppingList.CalculateSum("c:\\Training\\training-solutions\\src\\main\\resources\\lst.txt"));
        assertEquals("File does not exist -> ", e.getMessage().substring(0,23));
    }

}