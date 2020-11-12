package week03;

public class Phone {
    private int prefix;
    private int number;

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Phone(int prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "prefix=" + prefix +
                ", number=" + number +
                '}';
    }
}
