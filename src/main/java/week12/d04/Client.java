package week12.d04;

public class Client implements Comparable<Client>{

    private String name;
    private String regNumber;

    public Client(String name, String regNumber) {
        this.name = name;
        this.regNumber = regNumber;
    }

    @Override
    public int compareTo(Client o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", regNumber='" + regNumber + '\'' +
                '}';
    }
}
