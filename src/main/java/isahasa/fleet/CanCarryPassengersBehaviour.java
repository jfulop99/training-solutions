package isahasa.fleet;

public class CanCarryPassengersBehaviour implements CanCarryPassengers{

    private int passengers;
    private int maxPassengers;

    public CanCarryPassengersBehaviour(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public int loadPassenger(int passengers) {
        int total = this.passengers + passengers;
        if (total < maxPassengers) {
            this.passengers = total;
            return 0;
        }
        this.passengers = maxPassengers;
        return total - maxPassengers;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }
}
