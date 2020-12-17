package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    void listOfExampleTest() {
        ExamplesStore examplesStore = new ExamplesStore();
        assertEquals(2, examplesStore.getTitlesOfExamples().size());
    }

}