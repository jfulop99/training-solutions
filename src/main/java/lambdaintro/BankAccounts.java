package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = new ArrayList<>(bankAccounts);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {

        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort((o1, o2) -> o1.getAccountNumber().compareTo(o2.getAccountNumber()));

        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalance() {

        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort((o1, o2) -> Double.compare(Math.abs(o1.getBalance()), Math.abs(o2.getBalance())));

        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {

        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort((o1, o2) -> -1 * (Double.compare(o1.getBalance(), o2.getBalance())));

        return sorted;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {

        List<BankAccount> sorted = new ArrayList<>(bankAccounts);
        sorted.sort((o1, o2) -> {

            Locale   locale = new Locale("hu", "HU");
            Collator collator = Collator.getInstance(locale);
            collator.setStrength(Collator.IDENTICAL);
            int result = 0;

            if (o1.getNameOfOwner() == null && o2.getNameOfOwner() == null) {
                return 0;
            }

            if (o1.getNameOfOwner() == null) {
                return -1;
            }

            if (o2.getNameOfOwner() == null) {
                return 1;
            }

            result = collator.compare(o1.getNameOfOwner(), o2.getNameOfOwner());

            return result == 0 ? o1.getAccountNumber().compareTo(o2.getAccountNumber()) : result;
        });

        return sorted;
    }



}
