package week05.d05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    @DisplayName("Test the main method")
    void mainTest() {


//        String input = "3\n4\n";
//        String expected = "12";

        String input = "0\n4\n";
        String expected = "java.lang.Exception: Breadth and height must be positive\r\n";



        // set stdin
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // set stdout
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);


        Solution.main(null);
        assertEquals(expected, baos.toString());

    }
}