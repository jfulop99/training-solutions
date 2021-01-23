package lambdastreams.bookstore;

public class Book {

    private String title;

    private int yearOfPublish;

    private int price;

    private int amount;

    public Book(String title, int yearOfPublish, int price, int amount) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
