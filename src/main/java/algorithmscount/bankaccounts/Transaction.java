package algorithmscount.bankaccounts;

import algorithmssum.transactions.TransactionOperation;

public class Transaction {

    private String accountNumber;
    private TransactionType transactionOperation;
    private int amount;

    public Transaction(String accountNumber, TransactionType transactionOperation, int amount) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDebit() {
        return transactionOperation == TransactionType.DEBIT ? true : false;
    }

    public boolean isCredit() {
        return transactionOperation == TransactionType.CREDIT ? true : false;
    }
}
