package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        if (books == null) {
            throw new NullPointerException();
        }
        if (books.size() == 0) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        Book first;
        try {
            first = (Book) books.get(0);
        } catch (ClassCastException e) {
            throw new ClassCastException("Not a book");
        }
        return first;

    }

}
