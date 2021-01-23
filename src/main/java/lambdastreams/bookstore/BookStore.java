package lambdastreams.bookstore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public long getNumberOfBooks() {

        return  books.stream().collect(Collectors.summarizingInt(Book::getAmount)).getSum();
    }

    public Optional<Book> findNewestBook() {

        return books.stream().max(Comparator.comparing(Book::getYearOfPublish));
    }


    public int getTotalValue() {

        return books.stream().mapToInt(value -> value.getPrice() * value.getAmount()).sum();
    }

    public List<Book> getByYearOfPublish(int year) {


        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(year);
    }

}
