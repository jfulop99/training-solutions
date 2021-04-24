package gyaxi.orokles.airport;

public enum PersonType {
    GROUND_STAFF(false), PASSENGER(true), PILOT(true), STEWARDESS(true);

    private final boolean travel;

    PersonType(boolean travel) {
        this.travel = travel;
    }

    public boolean isTravel() {
        return travel;
    }
}
