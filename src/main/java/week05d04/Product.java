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
        double changePrice = price;
        if (this.currency == Currency.HUF && currency == Currency.USD) {
            changePrice = price / 300.0;
        }
        if (this.currency == Currency.USD && currency == Currency.HUF) {
            changePrice = price * 300.0;
        }

        return changePrice;
    }
}
