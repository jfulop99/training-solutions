package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Micimackó visszatér");
        System.out.println(book.getTitle());
        book.setTitle("Tigris színre lép");
        System.out.println(book.getTitle());
    }
}
