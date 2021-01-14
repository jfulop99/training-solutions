package collectionsequalshash;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {


    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {

        for (Book item:books) {
            if (item.equals(new Book(title, author))) {
                return item;
            }
        }

        return null;
    }

    public Book findBook(List<Book> books, Book book) {

        Book foundBook = null;
        if (books.contains(book)) {
            foundBook = book;
        }
        return foundBook;
    }
    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        Collections.addAll(bookSet, books);
        return bookSet;
    }

}
