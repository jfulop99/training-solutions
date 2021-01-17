package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = new ArrayList<>(libraryBooks);
    }

    public List<Book> orderedByTitle() {

        List<Book> result = new ArrayList<>(libraryBooks);
        Collections.sort(result);

        return result;
    }

    public List<Book> orderedByAuthor() {

        List<Book> result = new ArrayList<>(libraryBooks);
//        Collections.sort(result, new AuthorComparator());
        result.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return result;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> result = new ArrayList<>();
        for (Book item:libraryBooks) {
            result.add(item.getTitle());
        }
        Collator collator = Collator.getInstance(locale);
//        collator.setStrength(Collator.PRIMARY);
        Collections.sort(result, collator);
        return result;
    }
}
