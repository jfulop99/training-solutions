package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream out, List<String> list) {
        try (PrintStream outputStream = new PrintStream(new BufferedOutputStream(out))) {
            for (String item: list) {
                outputStream.println(item);
            }
        }
    }

    public List<String> loadShoppingList(InputStream input) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))){
            String line;
            while ((line = reader.readLine()) != null) {
                shoppingList.add(line);
            }
        } catch (IOException | NullPointerException e) {
            throw new IllegalStateException("Cannot access file", e);
        }
        return shoppingList;
    }
}
