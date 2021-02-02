package lambdacollectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Cafe {

    private List<CoffeeOrder> orderList;

    public Cafe(List<CoffeeOrder> orderList) {
        this.orderList = new ArrayList<>(orderList);
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {

        return orderList.stream().flatMap(a -> a.getCoffeeList().stream()).collect(groupingBy(Coffee::getType, counting()));

    }

    public double getAverageOrder() {

        double average = orderList.stream().map(CoffeeOrder::getCoffeeList).collect(summarizingInt(List::size)).getAverage();

        average = Math.round(average * 10000) / 10000D;

        return average;
    }

}
