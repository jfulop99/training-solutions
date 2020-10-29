package classsctructureconstructors;

import java.util.Scanner;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void increasePrice(int price) {
        this.price = this.price + price;
    }

    public void decreasePrice(int price) {
        this.price = this.price - price;
    }

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
