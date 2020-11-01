package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {
        Performance performance1 = new Performance(LocalDate.of(2020, 2, 3), "Deep Purple", LocalTime.of(18, 00), LocalTime.of(22, 00));
        Performance performance2 = new Performance(LocalDate.of(1986, 8, 15), "Queen", LocalTime.of(18, 00), LocalTime.of(22, 00));

        System.out.println(performance1.getInfo());
        System.out.println(performance2.getInfo());
    }
}
