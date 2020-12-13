package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList;

    public TransactionManager() {
        accountList = new ArrayList<>();
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void uploadListFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line: lines) {
                String[] accountData = line.split(";");
                accountList.add(new BankAccount(accountData[0],accountData[1],Integer.parseInt(accountData[2])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void makeTransactions(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            for (String line: lines) {
                String[] transactionData = line.split(";");
                findAccount(transactionData[0]).setBalance(Integer.parseInt(transactionData[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account:accountList) {
            if (accountNumber.equals(account.getAccountNumber())){
                return account;
            }
        }
        return null;
    }
}
