package inheritancemethods.bankaccount;

public class DebitAccount {

    private String accountNumber;
    private long balance;
    private final double COST = 3.0;
    private final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        long cost = (long) Math.floor(amount * COST / 100.0);
        if (cost < MIN_COST) {
            cost = MIN_COST;
        }
        return cost;
    }

    public boolean transaction(long amount) {
        long total = amount + costOfTransaction(amount);
        if (balance > total) {
            balance -= total;
            return true;
        }
        return false;
    }

    public void balanceToZero() {
        balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
