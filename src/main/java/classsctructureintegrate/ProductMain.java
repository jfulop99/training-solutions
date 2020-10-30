package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        String productName;
        int price;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name: ");
        productName = scanner.nextLine();
        System.out.println("Enter price: ");
        price = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(productName,price);
        System.out.println("Product: " + product.getName() + " Price: " + product.getPrice());

        product.increasePrice(55);
        System.out.println("Product: " + product.getName() + " Price: " + product.getPrice());

        product.decreasePrice(100);
        System.out.println("Product: " + product.getName() + " Price: " + product.getPrice());
    }

}
