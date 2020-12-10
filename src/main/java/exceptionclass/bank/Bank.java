package exceptionclass.bank;

import java.util.List;

public class Bank {


    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Account list is null");
        }
        this.accounts = accounts;
    }

    public double payment(String accountNumber, double amount) {
        return findAccount(accountNumber).subtract(amount);
    }

    public double deposit(String accountNumber, double amount) {
        return findAccount(accountNumber).deposit(amount);
    }

    private Account findAccount(String accountnumber){
        for (Account account:accounts) {
            if (account.getAccountNumber().equals(accountnumber)) {
                return account;
            }
        }
        throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
}
