package collectionsequalshash;

public class Book {

    private String regNumber;
    private String title;
    private String author;

    public Book(String title, String author) {
        if (title == null || author == null) {
            throw new IllegalArgumentException("Wrong parameter(s)");
        }
        this.title = title;
        this.author = author;
        this.regNumber = "";
    }

    public Book(String regNumber, String title, String author) {
        this(title, author);
        if (regNumber == null) {
            throw new IllegalArgumentException("Wrong parameter(s)");
        }
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "regNumber='" + regNumber + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
