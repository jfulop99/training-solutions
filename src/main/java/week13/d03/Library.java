package week13.d03;

import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public String getMostPagesPerAuthor(List<Book> bookList) {

        if (bookList == null || bookList.isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        }

        Map<String, List<Book>> library = new HashMap<>();

        for (Book book: bookList) {
            library.computeIfAbsent(book.getAuthor(), b -> new ArrayList<>()).add(book);
        }

        System.out.println(library);

        int mostPages = 0;
        String author = null;


        for (Map.Entry<String, List<Book>> item: library.entrySet()) {
            int sum = summarizePages(item.getValue());
            if ( sum > mostPages) {
                mostPages = sum;
                author = item.getKey();
            }
        }

        return author;

    }


    public Optional<String> getMostPagesPerAuthorV2(List<Book> bookList) {

        if (bookList == null || bookList.isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        }

        Map<String, Integer> library = new HashMap<>();

        for (Book book: bookList) {
            String author = book.getAuthor();
            library.merge(author, book.getNumberOfPages(), Integer::sum);
        }

        System.out.println(library);

        int maxNumberOfPages = 0;
        String author = null;


        for (Map.Entry<String, Integer> item: library.entrySet()) {
            int numberOfPages = item.getValue();
            if ( numberOfPages > maxNumberOfPages) {
                maxNumberOfPages = numberOfPages;
                author = item.getKey();
            }
        }

        return Optional.of(author);

    }

    private int summarizePages(List<Book> books) {
        int sum = 0;
        for (Book book:books) {
            sum += book.getNumberOfPages();
        }
        return sum;
    }


    public Optional<String> getMostPagesPerAuthorWithStream(List<Book> bookList) {

        if (bookList == null || bookList.isEmpty()) {
            throw new IllegalArgumentException("Cannot be empty");
        }

        return bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingInt(Book::getNumberOfPages))).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);

    }

}
