package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum;
        do {
            sum = 0;
            System.out.println("Írj be öt számot! (kilép ha az összeg = 0)");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i + ". szám:");
                sum = sum + scanner.nextInt();
            }
            System.out.println("Az öt szám összege: " + sum);
        }while (sum != 0);
    }
}
