package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titleOfBooks = new ArrayList<>();

    public void add(String title) {
        titleOfBooks.add(title);
    }

    public List<String> getTitles() {
        return titleOfBooks;
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> hit = new ArrayList<>();
        for ( String title : titleOfBooks) {
            if (title.startsWith(prefix)) {
                hit.add(title);
            }
        }
        return hit;
    }

    public void removeByPrefix(String prefix) {
        List<String> hit = new ArrayList<>();
        for ( String title : titleOfBooks) {
            if (title.startsWith(prefix)) {
                hit.add(title);
            }
        }

        titleOfBooks.removeAll(hit);
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Elfújta a szél");
        books.add("Java programozás");
        books.add("Java a gyakorlatban");
        books.add("14 karátos autó");

        System.out.println(books.getTitles());
        System.out.println(books.findAllByPrefix("Jav"));
        System.out.println();
        books.removeByPrefix("Jav");
        System.out.println(books.getTitles());
    }
}
