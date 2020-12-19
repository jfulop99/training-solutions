package iofiletest.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void add(Book book) {

        if (!findBook(book)) {
            books.add(book);
        }
    }

    public void saveBooks(Path path) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8)))) {
            for (Book book:books) {
                writer.println(book.getAuthor() + ";" + book.getTitle());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }


    public void loadBooks(Path path) {

        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(";");
                add(new Book(parts[0], parts[1]));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void clearLibrary() {
        books.clear();
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    private boolean findBook(Book book) {
        for (Book item:books) {
            if (item.equals(book)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.add(new Book("Rejtő Jenő", "14 karátos autó"));
        library.add(new Book("Rejtő Jenő", "Az elveszett cirkáló"));
        library.add(new Book("Moldova György", "Akit a mozdony füstje megcsapott"));
        library.add(new Book("Joshua Bloch", "Effective Java"));

        System.out.println(library.getBooks().size());

        library.getBooks().add(new Book("Joshua Bloch", "Effective Java"));

        System.out.println(library.getBooks().size());

        System.out.println(library.getBooks().get(0).equals(new Book("Rejtő Jenő", "14 karátos autó")));

        library.saveBooks(Path.of("temp/iofiletest/books.txt"));

        library.loadBooks(Path.of("temp/iofiletest/books.txt"));

        System.out.println(library.getBooks().size());

        library.clearLibrary();

        System.out.println(library.getBooks().size());

        library.loadBooks(Path.of("temp/iofiletest/books.txt"));

        System.out.println(library.getBooks().size());

        System.out.println(library.getBooks().get(0).equals(new Book("Rejtő Jenő", "14 karátos autó")));

    }
}
