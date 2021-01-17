package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    Set<Book> libraryBooks = new HashSet<>();

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = new HashSet<>(libraryBooks);
    }

    public Book findBookByRegNumber(int regNumber) {
        Book result;
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();
            if (result.getRegNumber() == regNumber) {
                return result;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        libraryBooks.remove(findBookByRegNumber(regNumber));
        return regNumber;
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()) {
            Book item = iterator.next();
            if (item.getAuthor().equals(author)) {
                result.add(item);
            }
        }
        if (result.isEmpty()) {
            throw new MissingBookException("No books found by " + author);
        }
        return result;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
