package lambdaintro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {

    @Test
    public void testCreate() {
        BankAccount bankAccount = new BankAccount("12345678-12345678", "John Doe", 100.5);

        assertEquals("12345678-12345678", bankAccount.getAccountNumber());
        assertEquals("John Doe", bankAccount.getNameOfOwner());
        assertEquals(100.5, bankAccount.getBalance());
    }


    @Test
    public void testCompareTo() {
        BankAccount bankAccount = new BankAccount("12345678-12345678", "John Doe", 100.5);

        BankAccount anotherBankAccount = new BankAccount("92345782-12345678", "Jack Doe", 100.5);

        assertTrue(0 > bankAccount.compareTo(anotherBankAccount));

    }

}