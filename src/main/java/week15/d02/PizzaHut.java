package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaHut {


    private List<Order> orderList;

    public PizzaHut(BufferedReader reader) {
        orderList = new ArrayList<>();
        readFile(reader);
    }

    public List<Order> getOrderList() {
        return orderList;
    }


    private void readFile(BufferedReader reader) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        AtomicReference<LocalDate> orderDate = new AtomicReference<>();
        AtomicReference<String> currier = new AtomicReference<>();

        try (Stream<String> lines = reader.lines()) {
            orderList = lines
                    .map(line -> {
                        if (line.length() == 10) {
                            orderDate.set(LocalDate.parse(line, dateFormatter));
                        } else if (line.startsWith("FUT")) {
                            currier.set(line);
                        } else {
                            return new Order(orderDate.get(), currier.get(), line);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
    }


    public LocalDate worstDay() {
        return orderList.stream()
                .collect(Collectors.groupingBy(Order::getOrderDate))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public String bestConsumer() {
        return orderList.stream()
                .collect(Collectors.groupingBy(a -> a.getZipNumber() + " " + a.getAddress()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Optional<Order> getOrderByDateTime(LocalDateTime orderDateTime) {
        return orderList.stream()
                .filter(getOrderPredicate(orderDateTime))
                .findAny();
    }

    private Predicate<Order> getOrderPredicate(LocalDateTime orderDateTime) {
        return a -> {
            LocalDate orderDate = orderDateTime.toLocalDate();
            LocalTime orderTime = orderDateTime.toLocalTime();
            return a.getOrderDate().equals(orderDate) && a.getOrderTime().equals(orderTime);
        };
    }

    public Map<String, Integer> getCurrierStatistic() {
        return orderList.stream()
                .collect(Collectors.groupingBy(Order::getCurrier))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, a -> a.getValue().size()));
    }

    public static void main(String[] args) {
        PizzaHut pizzaHut = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(PizzaHut.class.getResourceAsStream("orders.txt")))) {
            pizzaHut = new PizzaHut(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        System.out.println("Orders: " + pizzaHut.getOrderList());
        System.out.println("The worst day: " + pizzaHut.worstDay());
        System.out.println("The best consumer: " + pizzaHut.bestConsumer());
        System.out.println("Currier statistic:");
        pizzaHut.getCurrierStatistic()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println("Order at the selected time: " + pizzaHut.getOrderByDateTime(LocalDateTime.of(2020, 2, 02, 12, 40))
                .orElse(new Order(LocalDate.now(), "XXXX", "There is_no_such order " + LocalTime.now().toString().substring(0, 5))));
    }


}
