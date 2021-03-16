package finalexampractice;

public class OfficeSoftware extends Software {
    public OfficeSoftware(String name, double price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        price = price * 1.05;
    }
}
