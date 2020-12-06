package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers{

    private CanCarryPassengers liner;


    public Liner(int maxPassengers) {
        liner = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadPassenger(int passengers) {
        return liner.loadPassenger(passengers);
    }

    @Override
    public int getPassengers() {
        return liner.getPassengers();
    }
}
