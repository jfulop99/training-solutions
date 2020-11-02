package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Írj be egy számot!");
        if (scanner.nextInt() > 100) {
            System.out.println("nagyobb, mint szaaz");
        }
        else {
            System.out.println("száz, vagy kisebb");
        }
    }
}
