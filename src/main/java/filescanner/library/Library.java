package filescanner.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void loadFromFile(){
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream("/books.csv")).useDelimiter(";|(\r\n)")){
            while (scanner.hasNext()){
                books.add(new Book(scanner.next(), scanner.next(), scanner.next(), Integer.parseInt(scanner.next())));
            }
        }
    }
}
