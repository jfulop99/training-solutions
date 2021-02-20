package xtest.exchangerates;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Currency {

    /*Név;Érvényesség;Egység;Közép;Valuta vételi;Valuta eladási;Csekk vételi;Csekk eladási;Deviza vételi;Deviza eladási;Verzió
            EUR;2019.12.02 05:56;1;334,64;325,27;340,89;328,38;340,89;331,29;337,98;1*/


    private CurrencyType currencyType;
    private LocalDateTime validAt;
    private int unit;
    private BigDecimal midRate;
    private BigDecimal currencyBuy;
    private BigDecimal currencySale;
    private BigDecimal checkBuy;
    private BigDecimal checkSale;
    private BigDecimal foreignCurrencyBuy;
    private BigDecimal foreignCurrencySale;
    private int version;


    public Currency(CurrencyType currencyType, LocalDateTime validAt, int unit, BigDecimal midRate,
                    BigDecimal currencyBuy, BigDecimal currencySale, BigDecimal checkBuy, BigDecimal checkSale,
                    BigDecimal foreignCurrencyBuy, BigDecimal foreignCurrencySale, int version) {
        this.currencyType = currencyType;
        this.validAt = validAt;
        this.unit = unit;
        this.midRate = midRate;
        this.currencyBuy = currencyBuy;
        this.currencySale = currencySale;
        this.checkBuy = checkBuy;
        this.checkSale = checkSale;
        this.foreignCurrencyBuy = foreignCurrencyBuy;
        this.foreignCurrencySale = foreignCurrencySale;
        this.version = version;
    }

    public static Currency parse(String line) {
        String[] parts = CsvSplitter.split(line, ";");

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        for (int i = 3; i < 10; i++) {
            parts[i] = parts[i].replace(",", ".");
        }

        return new Currency(CurrencyType.valueOf(parts[0]), LocalDateTime.parse(parts[1], format), Integer.parseInt(parts[2]),
                new BigDecimal(parts[3]), new BigDecimal(parts[4]), new BigDecimal(parts[5]), new BigDecimal(parts[6]),
                new BigDecimal(parts[7]), new BigDecimal(parts[8]), new BigDecimal(parts[9]), Integer.parseInt(parts[10]));

    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyType=" + currencyType +
                ", validAt=" + validAt +
                ", midRate=" + foreignCurrencySale +
                ", version=" + version +
                '}';
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public LocalDateTime getValidAt() {
        return validAt;
    }

    public BigDecimal getForeignCurrencySale() {
        return foreignCurrencySale;
    }

    public int getVersion() {
        return version;
    }
}
