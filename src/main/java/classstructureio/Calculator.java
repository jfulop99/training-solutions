package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg két számot !");
        int operand1 = scanner.nextInt();
        int operand2 = scanner.nextInt();
        System.out.println(operand1 + " + " + operand2);
        System.out.println(operand1 + operand2);
    }
}
