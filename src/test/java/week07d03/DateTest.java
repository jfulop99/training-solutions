package week07d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void dateTest() {
        Date date = Date.of(1981,12,23);

        assertEquals(1981, date.getYear() );
        assertEquals(12, date.getMonth() );
        assertEquals(23, date.getDay() );

    }

    @Test
    void dateTestWithYear() {
        Date date = Date.of(1981,12,23);

        Date newDate = date.withYear(1998);

        assertEquals(1998, newDate.getYear() );
        assertEquals(12, newDate.getMonth() );
        assertEquals(23, newDate.getDay() );

    }

}