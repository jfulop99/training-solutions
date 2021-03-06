package week03.d04;

public class Phone {
    private String prefix;
    private String number;

    @Override
    public String toString() {
        return prefix + "-" + number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phone(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }
}
