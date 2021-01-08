package week10.d05;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Calculator2Test {

    @Test
    void main() {

        //main();
// Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
// IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
// Tell Java to use your special stream
        System.setOut(ps);
// Print some output: goes to your special stream

        //System.out.println("Foofoofoo!");
        Calculator2.findMinMaxSum(new int[]{1,2,3,4,5});
// Put things back
        System.out.flush();
        System.setOut(old);
// Show what happened
        System.out.println("Here: " + baos.toString());
        assertEquals("A legkissebbek összege: 10\r\nA legnagyobbak összege: 14", baos.toString());
    }
}