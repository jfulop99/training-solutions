package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Rejtő Jenő", "14 karátos autó");
        book.regNumber("112-234-5678");

        System.out.println("Author: " + book.getAuthor() + " Title: " + book.getTitle() + " RegNumber: " + book.getRegNumber());
    }
}
