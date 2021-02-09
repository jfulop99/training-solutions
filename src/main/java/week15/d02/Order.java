package week15.d02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH.mm");

    private final LocalDate orderDate;

    private final LocalTime orderTime;

    private final String address;

    private final String zipNumber;

    private final String currier;


    public Order(LocalDate orderDate, String currier, String order) {
        this.orderDate = orderDate;
        this.currier = currier;
        String[] parts = order.split(" ");
        zipNumber = parts[0].trim();
        orderTime = LocalTime.parse(parts[3].trim());
        address = parts[1] + " " + parts[2];
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public String getAddress() {
        return address;
    }

    public String getZipNumber() {
        return zipNumber;
    }

    public String getCurrier() {
        return currier;
    }

    @Override
    public String toString() {
        return orderDate + " " + orderTime + " " + zipNumber + " " + address + " " + currier;
    }
}
