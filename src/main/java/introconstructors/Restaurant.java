package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        capacity = numberOfTables * 4;
    }

    public void menuGenerator(){
        menu.add("Cordon bleu");
        menu.add("Wiener Schnitzel");
        menu.add("Pizza");
        menu.add("Rib eye steak");
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
