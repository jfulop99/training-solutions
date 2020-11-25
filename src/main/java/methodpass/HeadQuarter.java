package methodpass;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers;

    public HeadQuarter() {
        troopers = new ArrayList<>();
    }

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("xxx");
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        moveTrooper(findTrooperByName(name), target);
    }

    public void moveClosestTrooper(Position target) {
        moveTrooper(findClosestTrooper(target), target);
    }

    private Trooper findTrooperByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("xxx");
        }
        for (Trooper trooper:troopers) {
            if (name.equals(trooper.getName())) {
                return trooper;
            }
        }
        return null;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        if (trooper == null || target == null) {
            throw new IllegalArgumentException("xxx");
        }
        trooper.changePosition(target);
    }

    private Trooper findClosestTrooper(Position target) {
        double distance = Double.MAX_VALUE;
        Trooper closestTrooper = null;
        for (Trooper trooper : troopers ) {
            if (trooper.distanceFrom(target) < distance) {
                closestTrooper = trooper;
                distance = trooper.distanceFrom(target);
            }
        }
        return closestTrooper;
    }
}
