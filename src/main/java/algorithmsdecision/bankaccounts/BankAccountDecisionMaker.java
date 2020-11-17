package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> accounts, int limit) {
        boolean isGreaterThanLimit = false;
        for (BankAccount account:accounts) {
            if (account.getBalance() > limit) {
                isGreaterThanLimit = true;
                break;
            }
        }
        return isGreaterThanLimit;
    }
}
