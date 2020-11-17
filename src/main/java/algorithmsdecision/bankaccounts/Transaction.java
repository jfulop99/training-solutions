package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;

public class Transaction {

    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;
    private LocalDateTime dateOfTransaction;
    private String status;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount, LocalDateTime dateOfTransaction) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.dateOfTransaction = dateOfTransaction;
        status = "CREATED";
    }

    public boolean isDebit(){
        return transactionOperation.equals(TransactionOperation.DEBIT) ? true : false;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCredit(){
        return transactionOperation.equals(TransactionOperation.CREDIT) ? true : false;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }
}
