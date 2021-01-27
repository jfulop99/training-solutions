package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = new ArrayList<>(coffeeOrders);
    }

    public void addNewOrder(Coffee...coffees) {
        if (coffees.length == 0) {
            throw new IllegalArgumentException("No coffee");
        }
        coffeeOrders.add(new CoffeeOrder(List.of(coffees), LocalDateTime.now()));
    }

    public BigDecimal getTotalIncome() { //: az eddigi összes bevétel

        return coffeeOrders.stream().flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream())
                .map(Coffee::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);

    }

    public BigDecimal getTotalIncome(LocalDate date) { //: adott napi teljes bevétel

        return coffeeOrders.stream().filter( xdate -> xdate.getDateTime().toLocalDate().isEqual(date))
                .flatMap(coffeeOrder -> coffeeOrder.getCoffeeList().stream()).map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);

    }

    public int getNumberOfCoffee(CoffeeType type) { //: az adott típusú kávéból eladott összmennyiség

        return (int) coffeeOrders.stream().flatMap(order -> order.getCoffeeList()
                .stream().filter(coffee -> coffee.getType().equals(type))).count();

    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) { //: a megadott időpont utáni rendelések listája

        return coffeeOrders.stream().filter(order -> order.getDateTime().isAfter(from)).collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) { //: adott napon az első 5 vásárlásban lévő kávék listája
        return coffeeOrders.stream().filter(order -> order.getDateTime()
                .toLocalDate().isEqual(date)).sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5).collect(Collectors.toList());
    }
}
