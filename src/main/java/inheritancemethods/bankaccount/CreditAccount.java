package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount{

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean transaction(long amount){

        if(super.transaction(amount)) {
            return true;
        }
        long total = amount + costOfTransaction(amount);
        if (overdraftLimit + getBalance() >= total) {
            total -= getBalance();
            balanceToZero();
            overdraftLimit -= total;
            return true;
        }
        return false;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
