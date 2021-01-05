package genericsusage;

public class Book {

    private final String title;

    public Book(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
