package sorting;

import java.util.Collections;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = new TreeSet<>(library);
    }

    public Book lendFirstBook() {

        if (library == null || library.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }

        return library.iterator().next();
    }

}
