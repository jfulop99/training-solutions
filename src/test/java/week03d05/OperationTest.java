package week03d05;

import org.junit.jupiter.api.Test;
import week03d05.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    void additonTest(){
        Operation operation = new Operation("161+18");
        operation.getResult();
        assertEquals(179, operation.getResult());
    }
}
