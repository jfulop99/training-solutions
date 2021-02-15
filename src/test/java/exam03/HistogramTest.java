package exam03;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistogramTest {

    @Test
    void printHistogram() {

        Histogram histogram = new Histogram();
        StringReader str = new StringReader("3\n4\n1\n2");

        try (BufferedReader reader = new BufferedReader(str);) {

            assertEquals("***\n****\n*\n**\n", histogram.printHistogram(reader));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}