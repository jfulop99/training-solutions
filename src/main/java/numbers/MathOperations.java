package numbers;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Számolj!  (23,28)");
        System.out.print("(2+5,63*12-23)/2=");
        double guess = scanner.nextDouble();
        double result = (2+5.63*12-23)/2;
        System.out.println(Math.abs(guess - result) < 1e-4 ? "Gratulálunk! Jó megoldás!" : "Rossz megoldás! ");
    }


}
