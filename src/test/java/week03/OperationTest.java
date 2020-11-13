package week03;

import operators.Operators;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    void additonTest(){
        Operation operation = new Operation("161+18");
        operation.getResult();
        assertEquals(179, operation.getResult());
    }
}
