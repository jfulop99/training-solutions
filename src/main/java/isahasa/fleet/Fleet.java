package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> fleet = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;


    public void addShip(Ship ship) {
        fleet.add(ship);
    }

    public void loadShip(int passengers, int cargoWeight) {
        waitingCargo = cargoWeight;
        waitingPersons = passengers;
        for (Ship ship: fleet) {
            if (ship instanceof CanCarryPassengers) {
                waitingPersons = ((CanCarryPassengers) ship).loadPassenger(waitingPersons);
            }
            if (ship instanceof CanCarryGoods) {
                waitingCargo = ((CanCarryGoods) ship).loadCargo(waitingCargo);
            }
            if (waitingPersons + waitingCargo == 0){
                return;
            }
        }
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
