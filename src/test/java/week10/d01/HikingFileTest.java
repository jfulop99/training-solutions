package week10.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void getElevation() {

        HikingFile hikingFile = new HikingFile();
        LevelChange levelChange = hikingFile.getElevation(HikingFile.class.getResourceAsStream("tracker.txt"));

        assertEquals(40.0, levelChange.getLifting());
        assertEquals( 30.0, levelChange.getDescent());

    }
}