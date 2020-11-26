package initalizer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private long balance;
//    private Currency currency;
    private static final List<Rate> ACTUAL_RATES = new ArrayList<>();


    public CreditCard(long balance, Currency currency, List<Rate> actualRates) {
        if (actualRates == null) {
            throw new IllegalStateException("Rates must not be null.");
        }
        ACTUAL_RATES.addAll(actualRates);
        if (currency == null) {
            throw new IllegalStateException("Currency must not be null.");
        }
        this.balance = Math.round(balance * getConversionFactor(currency));
    }


    public CreditCard(long balance, Currency currency) {
        if (currency == null) {
            throw new IllegalStateException("Currency must not be null.");
        }
        this.balance = Math.round(balance * getConversionFactor(currency));
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public boolean payment(long amount, Currency currency) {
        long credit = Math.round(amount * getConversionFactor(currency));
        if (credit < balance) {
            balance = balance - credit;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        if (amount < balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    private double getConversionFactor(Currency currency) {
        double conversionFactor = 0;
        for (Rate rate: ACTUAL_RATES) {
            if (currency == rate.getCurrency()) {
                 conversionFactor = rate.getConversionFactor();
            }
        }
        return conversionFactor;
    }

    public long getBalance() {
        return balance;
    }
}
