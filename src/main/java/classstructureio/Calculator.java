package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg két számot !");
        int firstOperand = scanner.nextInt();
        int secondOperand = scanner.nextInt();
        System.out.println(firstOperand + " + " + secondOperand);
        System.out.println(firstOperand + secondOperand);
    }
}
