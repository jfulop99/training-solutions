package immutable.satellite;

public class Satellite {

    private CelestialCoordinates celestialCoordinates;
    private String name;

    public Satellite(CelestialCoordinates celestialCoordinates, String name) {
        this.celestialCoordinates = celestialCoordinates;
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }else {
            this.name = name;
        }
    }

    public void modifyDestination(CelestialCoordinates celestialCoordinates) {
        int x = celestialCoordinates.getX() + this.celestialCoordinates.getX();
        int y = celestialCoordinates.getY() + this.celestialCoordinates.getY();
        int z = celestialCoordinates.getZ() + this.celestialCoordinates.getZ();
        this.celestialCoordinates = new CelestialCoordinates(x, y, z);
    }

    public String getName() {
        return name;
    }

    public CelestialCoordinates getCelestialCoordinates() {
        return celestialCoordinates;
    }

    @Override
    public String toString() {
        return name + ": " + celestialCoordinates;
    }

    private boolean isEmpty(String name) {
        return (name == null || name.trim().length() == 0);
    }
}
