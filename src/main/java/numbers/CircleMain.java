package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first diameter:");
        Circle circle1 = new Circle(scanner.nextInt());
        System.out.println("Enter second diameter:");
        Circle circle2 = new Circle(scanner.nextInt());

        System.out.println(circle1);
        System.out.println(circle2);
    }
}
