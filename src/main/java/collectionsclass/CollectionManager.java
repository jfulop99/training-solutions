package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        if (library == null || library.isEmpty()) {
            throw new IllegalArgumentException("Library cannot be null or empty");
        }
        this.library = new ArrayList<>(library);
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }//módosíthatatlan listát eredményez

    public List<Book> reverseLibrary() {
        List<Book> reverselist = new ArrayList<>(library);
        Collections.sort(reverselist);
        Collections.reverse(reverselist);
        return reverselist;
    }//az eredeti lista másolatán dolgozik!

    public Book getFirstBook() {
        return Collections.min(library);
    }//a legrégebbi (legkisebb id) könyvet adja vissza

    public Book getLastBook() {
        return Collections.max(library);
    }// a legújabb (legnagyobb id) könyvet adja vissza

}
