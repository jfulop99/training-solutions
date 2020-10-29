package classsctructureconstructors;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }

    public String getInfo() {
        return owner + " (" + accountNumber + ") : " + balance + " Ft";
    }

    public void transfer(BankAccount to, int amount) {
        to.balance = to.balance + amount;
        this.balance = this.balance - amount;
    }
}
