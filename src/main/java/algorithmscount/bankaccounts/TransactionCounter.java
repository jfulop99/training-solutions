package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int limit) {
        int counter = 0;
        for (Transaction trasaction:transactions) {
            if (trasaction.getAmount() < limit) {
                counter++;
            }
        }
        return counter;
    }
}
