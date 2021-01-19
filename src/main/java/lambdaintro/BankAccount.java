package lambdaintro;

public class BankAccount implements Comparable<BankAccount>{

    private String accountNumber;

    private String NameOfOwner;

    private double balance;

    public BankAccount(String accountNumber, String nameOfOwner, double balance) {
        this.accountNumber = accountNumber;
        NameOfOwner = nameOfOwner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameOfOwner() {
        return NameOfOwner;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(BankAccount o) {
        return accountNumber.compareTo(o.getAccountNumber());
    }
}
