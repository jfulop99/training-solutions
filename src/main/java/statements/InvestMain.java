package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        int fund;
        int interestRate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("A befektetés összege:");
        fund = scanner.nextInt();
        System.out.println("Kamatláb:");
        interestRate = scanner.nextInt();
        Investment investment = new Investment(fund,interestRate);
        System.out.println("Tőke: " + investment.getFund());
        System.out.println("Hozam 50 napra:  " + investment.getYield(50));
        System.out.println("Kivett összeg 80 nap után: " + investment.close(80));
        System.out.println("Kivett összeg 90 nap után: " + investment.close(90));
    }
}
