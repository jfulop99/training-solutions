package week13.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AirportTest {

    private Airport airport;

    @BeforeEach
    void setUp() {

        airport = new Airport();

        airport.readDataFromFile(new BufferedReader(new InputStreamReader(Airport.class.getResourceAsStream("cities.txt"))));

    }

    @Test
    void readDataFromFile() {
        List<Flight> fleet = airport.getFlightList();
//        fleet.forEach(System.out::println);
        assertEquals(100, fleet.size());

        assertEquals( "FC5354", fleet.get(0).getFlightNumber());

        assertEquals( "SW1667", fleet.get(fleet.size()-1).getFlightNumber());


    }

    @Test
    void compareDirectionCount() {

        assertEquals(Direction.DEPARTURE, airport.compareDirectionCount());

    }

    @Test
    void getFlightByFlightNumber() {

        Flight found = airport.getFlightByFlightNumber("DU7236");
        assertEquals("Wien", found.getCity());

        Exception e = assertThrows(IllegalArgumentException.class, () -> airport.getFlightByFlightNumber("BU1111"));
        assertEquals("No flight", e.getMessage());
    }

    @Test
    void getFirstFlight() {

        System.out.println(airport.getFirstDepartureFlight());

        assertEquals("FG3210", airport.getFirstDepartureFlight().getFlightNumber());

    }

    @Test
    void listFlightByCityAndDirection() {

        Scanner scanner = new Scanner("Bucharest\nDeparture\n");
        List<Flight> result = airport.listFlightByCityAndDirection(scanner);
        result.forEach(System.out::println);

        assertEquals(2, result.size());

        assertEquals("SO1583", result.get(1).getFlightNumber());
    }
}