package week13.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZipNumbersTest {


    @Test
    void getFirstCityByName() {

        ZipNumbers zipNumbers = new ZipNumbers();

        assertEquals( "Aba", zipNumbers.getFirstCityByName().getName());

    }
}