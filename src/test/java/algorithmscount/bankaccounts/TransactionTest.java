package algorithmscount.bankaccounts;

import algorithmssum.transactions.Transaction;
import algorithmssum.transactions.TransactionOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testCreateTransaction() {
        algorithmssum.transactions.Transaction transaction = new Transaction("1234-2345-1231", TransactionOperation.CREDIT, 100000);

        assertEquals(100000, transaction.getAmount());
        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
    }
}
