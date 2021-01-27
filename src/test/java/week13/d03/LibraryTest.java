package week13.d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    private Library library;

    private List<Book> bookList = new ArrayList<>(Arrays.asList(
                new Book("A", "T1", 10),
                new Book("A", "T2", 20),
                new Book("B", "T3", 100),
                new Book("C", "T4", 100),
                new Book("C", "T5", 100),
                new Book("B", "Nagy könyv", 5000)));

    @BeforeEach
    void setUp() {

        library = new Library();

    }

    @Test
    void getMostPagesPerAuthor() {

        assertEquals("B", library.getMostPagesPerAuthor(bookList));

    }

    @Test
    void getMostPagesPerAuthorWithStream() {

        assertEquals("B", library.getMostPagesPerAuthorWithStream(bookList).get());

    }

    @Test
    void getMostPagesPerAuthorV2() {

        assertEquals("B", library.getMostPagesPerAuthorV2(bookList).get());

    }
}