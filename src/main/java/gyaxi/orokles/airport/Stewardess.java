package gyaxi.orokles.airport;

public class Stewardess extends Person {
    private Position position;

    public Stewardess(String name, int age, Position position) {
        super(name, age, PersonType.STEWARDESS);
        this.position = position;
    }

    public Stewardess(String name, Position position) {
        super(name, null, PersonType.STEWARDESS);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Stewardess that = (Stewardess) o;

        return position == that.position;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
