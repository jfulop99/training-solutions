package week11.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    private Courier courier = new Courier();

    @Test
    void readFile() {

        courier.readFile();
        assertEquals(61, courier.getRides().size());

        assertEquals(1, courier.getRides().get(2).getDay());
        assertEquals(1, courier.getRides().get(2).getNo());
        assertEquals(3, courier.getRides().get(2).getDistance());

        assertEquals(5, courier.getRides().get(60).getDay());
        assertEquals(20, courier.getRides().get(60).getNo());
        assertEquals(7, courier.getRides().get(60).getDistance());
    }

    @Test
    void getDistanceByDay() {

        List<WeekDistances> weekDistances = courier.getDistanceByDay();

        assertEquals(7, weekDistances.size());

        assertEquals(65, weekDistances.get(0).getDistance());
        assertEquals(0, weekDistances.get(1).getDistance());
        assertEquals(69, weekDistances.get(2).getDistance());
        assertEquals(62, weekDistances.get(3).getDistance());
        assertEquals(74, weekDistances.get(4).getDistance());
        assertEquals(0, weekDistances.get(5).getDistance());
        assertEquals(75, weekDistances.get(6).getDistance());

    }

    @Test
    void getFirstRide() {
        Ride ride = courier.getFirstRide();

        assertEquals(1, ride.getDay());
        assertEquals(1, ride.getNo());
        assertEquals(3, ride.getDistance());
    }

    @Test
    void getMissingDays() {

        List<WeekDistances> weekDistances = courier.getMissingDays();

        assertEquals(2, weekDistances.size());

        assertEquals(2, weekDistances.get(0).getDay());
        assertEquals(6, weekDistances.get(1).getDay());

    }
}