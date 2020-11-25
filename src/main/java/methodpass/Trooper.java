package methodpass;

public class Trooper {


    private String name;
    private Position position = new Position(0, 0);

    public Trooper(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.name = name;
    }

    public void changePosition(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        position = target;
    }

    public double distanceFrom(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        return position.distanceFrom(target);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
