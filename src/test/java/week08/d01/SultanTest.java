package week08.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SultanTest {

    @Test
    void openDoorTest() {
        Sultan sultan = new Sultan();
        List<Integer> openDoors = sultan.openDoors();
        int item = 1;
        for (Integer openDoor:openDoors) {
            assertEquals(Math.pow(item, 2), openDoor.intValue());
            item++;
        }
    }

}