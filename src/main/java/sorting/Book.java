package sorting;

public class Book implements Comparable<Book>{

    private int id;

    private String author;

    private String title;

    public Book(int id, String author, String title) {
        this(author, title);
        this.id = id;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book o) {
        return this.id - o.id;
    }
    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
