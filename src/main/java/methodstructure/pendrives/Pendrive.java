package methodstructure.pendrives;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        price = (int)Math.round(price * (1.0D + percent / 100.0D));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        int result;
        double cap1 = (double)price/capacity;
        double cap2 = (double)pendrive.getPrice()/pendrive.getCapacity();


        if (Math.abs(cap1 - cap2) < 1e-6) {
            result = 0;
        }
        else if (cap1 > cap2) {
            result = 1;
        }
        else {
            result = -1;
        }
        return result;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        return price < pendrive.getPrice() ? true : false;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
