package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public static void main(String[] args) {

        Phone phone1 = new Phone("Nokia", 64 );
        Phone phone2 = new Phone("Samsung", 128);

        System.out.println("Típus: " + phone1.getType() + "Memória: " + phone1.getMem());
        System.out.println("Típus: " + phone2.getType() + "Memória: " + phone2.getMem());
    }
}
