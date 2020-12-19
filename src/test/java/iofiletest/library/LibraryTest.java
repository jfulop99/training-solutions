package iofiletest.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;

    @TempDir
    public Path temporaryFolder;

    @BeforeEach
    void setUp() {

        library = new Library();

        library.add(new Book("Rejtő Jenő", "14 karátos autó"));
        library.add(new Book("Rejtő Jenő", "Az elveszett cirkáló"));
        library.add(new Book("Moldova György", "Akit a mozdony füstje megcsapott"));
        library.add(new Book("Joshua Bloch", "Effective Java"));

    }

    @Test
    void libraryCreateTest() {

        assertEquals(4, library.getBooks().size());
        library.getBooks().add(new Book("Joshua Bloch", "Effective Java"));
        assertEquals(4, library.getBooks().size());
        assertEquals(new Book("Joshua Bloch", "Effective Java"), library.getBooks().get(3));

    }

    @Test
    void librarySaveBooksTest() throws IOException {

        Path path = temporaryFolder.resolve("test.txt");
        library.saveBooks(path);
        BufferedInputStream reader = new BufferedInputStream(Files.newInputStream(path));
        //byte [] result = new byte[(int)path.toFile().length()];
        byte [] result = reader.readAllBytes();
        String s = new String(result, StandardCharsets.UTF_8);
        String expected =   "Rejtő Jenő" + ";" + "14 karátos autó" + System.lineSeparator() +
                            "Rejtő Jenő" + ";" + "Az elveszett cirkáló" + System.lineSeparator() +
                            "Moldova György" + ";" + "Akit a mozdony füstje megcsapott" + System.lineSeparator() +
                            "Joshua Bloch" + ";" + "Effective Java" + System.lineSeparator();
        assertEquals(expected, s);

    }

    @Test
    void libraryLoadBooksTest() throws IOException {

        Path path = temporaryFolder.resolve("test.txt");
        String expected =   "Rejtő Jenő" + ";" + "14 karátos autó" + System.lineSeparator() +
                "Rejtő Jenő" + ";" + "Az elveszett cirkáló" + System.lineSeparator() +
                "Moldova György" + ";" + "Akit a mozdony füstje megcsapott" + System.lineSeparator() +
                "Joshua Bloch" + ";" + "Effective Java" + System.lineSeparator();
        BufferedWriter bw = new BufferedWriter(Files.newBufferedWriter(path));
        bw.write(expected);
        bw.close();
        library.clearLibrary();
        assertEquals(0, library.getBooks().size());
        library.loadBooks(path);
        assertEquals(4, library.getBooks().size());
        assertEquals(new Book("Joshua Bloch", "Effective Java"), library.getBooks().get(3));
    }


}