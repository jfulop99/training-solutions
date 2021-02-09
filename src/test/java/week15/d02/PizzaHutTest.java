package week15.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaHutTest {

    private PizzaHut pizzaHut;

    @BeforeEach
    void setUp() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(PizzaHut.class.getResourceAsStream("orders.txt")))) {
            pizzaHut = new PizzaHut(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }

    @Test
    void getOrderList() {
        List<Order> orderList = pizzaHut.getOrderList();
        assertEquals(LocalTime.of(12, 30), orderList.get(0).getOrderTime());
        assertEquals("FUT_1", orderList.get(0).getCurrier());
    }

    @Test
    void worstDay() {
        assertEquals(LocalDate.of(2020, 12, 3), pizzaHut.worstDay());
    }

    @Test
    void bestConsumer() {
        assertEquals("1114 Kossuth 9", pizzaHut.bestConsumer());
    }

    @Test
    void getOrderByDateTime() {
        Order order = pizzaHut.getOrderByDateTime(LocalDateTime.of(2020, 12, 2, 12, 30)).get();
        assertEquals(LocalTime.of(12, 30), order.getOrderTime());
        assertEquals("FUT_1", order.getCurrier());
        assertEquals("Ady 12", order.getAddress());

        order = pizzaHut.getOrderByDateTime(LocalDateTime.of(2021, 12, 2, 12, 30))
                .orElse(new Order(LocalDate.now(), "XXXX", "There is_no_such order " + LocalTime.now().toString().substring(0, 5)));
        assertEquals(LocalDate.now(), order.getOrderDate());
        assertEquals("XXXX", order.getCurrier());
        assertEquals("is_no_such order", order.getAddress());
    }

    @Test
    void getCurrierStatistic() {
        assertEquals(7, pizzaHut.getCurrierStatistic().get("FUT_1"));
        assertEquals(5, pizzaHut.getCurrierStatistic().get("FUT_2"));
        assertEquals(2, pizzaHut.getCurrierStatistic().get("FUT_3"));
        assertEquals(2, pizzaHut.getCurrierStatistic().get("FUT_4"));
    }
}