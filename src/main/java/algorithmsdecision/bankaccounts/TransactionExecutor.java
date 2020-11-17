package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction transaction:transactions) {
            for (BankAccount account: accounts) {
                if (transaction.getAccountNumber().equals(account.getAccountNumber())) {
                    if (transaction.isDebit()) {
                        if (account.withdraw(transaction.getAmount())) {
                            transaction.setStatus("SUCCEDED");
                        } else {
                            transaction.setStatus("PENDING");
                        }
                    }
                    else {
                        if (account.deposit(transaction.getAmount())) {
                            transaction.setStatus("SUCCEDED");
                        }
                        else {
                            transaction.setStatus("PENDING");
                        }
                    }
                    break;
                }
            }
        }
    }
}
