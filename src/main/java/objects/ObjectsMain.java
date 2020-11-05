package objects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {
        new Book(); // Nem tudok hozzáférni később.

        System.out.println(new Book());

        Book emptyBook; //  Nem léhet használni, amíg nincs deklarálva.
        // System.out.println(emptyBook);

        emptyBook = null;
        System.out.println(emptyBook);

        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);
        Book anotherBook = new Book();

        System.out.println(book == anotherBook);
        anotherBook = book;
        System.out.println(book == anotherBook);
        System.out.println(anotherBook instanceof Book);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = book1;
        Book book5 = book1;
        Book book6 = book3;
        Book book7 = null;
        book4 = book5;
        book5 = new Book();
        book6 = null;
        System.out.println(book1.toString() + book2.toString() + book3.toString() + book5.toString());
        // négyet és mind hozzáférhető

        List<Book> listBook = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book());
        bookList.add(new Book());
        bookList.add(new Book());
    }

}
