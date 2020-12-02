package week06d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @Test
    void calculateSeriesTypeAscending() {

        Series series = new Series();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(-33,-22,-11,-2,3,4,5,6,7,8,9));

        assertEquals(SeriesTypes.ASCENDING_SERIES, series.calculateSeriesType(numbers));

    }
    @Test
    void calculateSeriesTypeDescending() {

        Series series = new Series();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,-1,-3,-5));

        assertEquals(SeriesTypes.DESCENDING_SERIES, series.calculateSeriesType(numbers));

    }
    @Test
    void calculateSeriesTypeUnsorted() {

        Series series = new Series();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(-33,-22,-11,-13,2,3,4,5,6,7,9));

        assertEquals(SeriesTypes.UNSORTED_SERIES, series.calculateSeriesType(numbers));

    }

    @Test
    void calculateSeriesTypeNull() {

        Series series = new Series();

        List<Integer> numbers = null;

        Exception e = assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(numbers));
        assertEquals("The series is null or too short!", e.getMessage());

    }

    @Test
    void calculateSeriesTypeShort() {

        Series series = new Series();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(2));

        Exception e = assertThrows(IllegalArgumentException.class, () -> series.calculateSeriesType(numbers));
        assertEquals("The series is null or too short!", e.getMessage());

    }
}