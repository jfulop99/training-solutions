package iodatastream.bank;

public class BankAccount {

    private String account;
    private String name;
    private double balance;

    public BankAccount(String account, String name, double balance) {
        this.account = account;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return account;
    }

    public String getOwner() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
