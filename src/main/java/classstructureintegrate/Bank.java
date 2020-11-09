package classstructureintegrate;

public class Bank {
    public static void main(String[] args) {
        BankAccount firstAccount = new BankAccount("11773345-00001111-00000000", "Tóth János", 113450);
        BankAccount secondAccount = new BankAccount("12345678-87654321-00000001", "Kiss Péter", 223650);

        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());
        // DEposit 1000FT
        System.out.println("+1000HUF");
        firstAccount.deposit(1000);
        secondAccount.deposit(1000);
        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());
        // Withdraw 2000 Ft
        System.out.println("-2000HUF");
        firstAccount.withdraw(2000);
        secondAccount.withdraw(2000);
        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());
        // Transfer first --> second 1000 Ft
        System.out.println("Tranfer 1-->2 +1000HUF");
        firstAccount.transfer(secondAccount, 1000);
        System.out.println(firstAccount.getInfo());
        System.out.println(secondAccount.getInfo());

    }
}
