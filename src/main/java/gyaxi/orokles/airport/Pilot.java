package gyaxi.orokles.airport;

public class Pilot extends Person {

    private Position position;

    public Pilot(String name, int age, Position position) {
        super(name, age, PersonType.PILOT);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
