package week07d04;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ShoppingList {

    long CalculateSum(String path) {
        long sum = 0L;
        File file = new File(path);
        String line = "";
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNext()) {
                line = sc.nextLine();
                String splitted[] = line.split(";");
                int quantity = Integer.parseInt(splitted[1]);
                int price = Integer.parseInt(splitted[2]);
                sum += quantity * price;
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File does not exist -> " + path);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Wrong input -> " + line);
        } catch (ArrayIndexOutOfBoundsException aob) {
            throw new IllegalArgumentException("Missing input data -> " + line);
        }
        return sum;
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        System.out.println(shoppingList.CalculateSum("c:\\Training\\training-solutions\\src\\main\\resources\\list.txt"));
    }
}


