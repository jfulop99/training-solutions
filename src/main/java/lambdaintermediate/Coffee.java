package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Coffee {

    private final CoffeeType type;

    private final BigDecimal price;

    public Coffee(CoffeeType type, BigDecimal price) {
        this.type = type;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public CoffeeType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
