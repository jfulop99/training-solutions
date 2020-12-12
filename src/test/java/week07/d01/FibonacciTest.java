package week07.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciTest() {
        assertEquals(13, Fibonacci.fib(7));
        assertEquals(13, Fibonacci.fib2(7));

    }

}