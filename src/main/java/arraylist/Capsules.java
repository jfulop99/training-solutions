package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> colorsOfCapsules = new ArrayList<>();

    public void addLast(String color) {
        colorsOfCapsules.add(color);
    }

    public void addFirst(String color) {
        colorsOfCapsules.add(0, color);
    }

    public void removeFirst() {
        colorsOfCapsules.remove(0);
    }

    public void removeLast() {
        colorsOfCapsules.remove(colorsOfCapsules.size()-1);
    }

    public List<String> getColors() {
        return colorsOfCapsules;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("Red");
        capsules.addFirst("Blue");
        capsules.addLast("Green");
        System.out.println(capsules.getColors());
        capsules.removeFirst();
        capsules.removeLast();
        System.out.println(capsules.getColors());

        System.out.println(capsules.getColors());
        List<String> temp = capsules.getColors();
        temp.clear();
        System.out.println(capsules.getColors());
    }
}

