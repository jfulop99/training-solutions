package week05d04;

public class Product {
    private long price;
    private Currency currency;

    public Product(long price, Currency currency) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency must not be null");
        }
        this.price = price;
        this.currency = currency;
    }

    public double convertPrice(Currency currency) {
        double changePrice = 0.0;
        if (this.currency.equals(currency)) {
            changePrice = price;
        }
//        else {
//                if (this.currency == Currency.HUF) {
//                    changePrice = Currency.USD.equals(currency.toString()) ? price * 300.0 : price / 300.0;
//                }
//                else {
//                    changePrice = Currency.USD.equals(currency.toString()) ? price / 300.0 : price * 300.0;
//                }
//        }
        if (this.currency == Currency.HUF && currency == Currency.USD) {
            changePrice = price / 300.0;
        }
        if (this.currency == Currency.USD && currency == Currency.HUF) {
            changePrice = price * 300.0;
        }

        return changePrice;
    }
}
