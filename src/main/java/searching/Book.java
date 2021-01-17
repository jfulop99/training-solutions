package searching;

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
        int compareAuthor = this.author.compareTo(o.author);
        if (compareAuthor != 0) {
            return compareAuthor;
        }
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
