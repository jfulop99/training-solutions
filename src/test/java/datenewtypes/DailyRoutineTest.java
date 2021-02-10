package datenewtypes;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DailyRoutineTest {


    @Test
    void constructor() {
        DailyRoutine dr = new DailyRoutine(9, 0);
        assertEquals(LocalTime.of(9, 0), dr.getStartTime());
    }

    @Test
    void stringConstructor() {
        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        assertEquals(LocalTime.of(9, 0), dailyRoutine.getStartTime());
    }

    @Test
    void setFutureTime() {
        DailyRoutine dr = new DailyRoutine(9, 0);
        dr.setFutureTime(3 * 45 + 20);
        assertEquals(LocalTime.of(11, 35), dr.getStartTime());
    }

    @Test
    void isBeforeNoon() {
        DailyRoutine dr = new DailyRoutine(9, 0);
        dr.setFutureTime(3 * 45 + 20);
        assertTrue(dr.isBeforeNoon());
    }

}