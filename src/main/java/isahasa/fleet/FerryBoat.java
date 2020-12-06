package isahasa.fleet;

public class FerryBoat implements Ship, CanCarryGoods, CanCarryPassengers{

    private CanCarryGoods cargoShip;
    private CanCarryPassengers liner;

    public FerryBoat(int maxCargoWeight, int maxPassengers) {
        cargoShip = new CanCarryGoodsBehaviour(maxCargoWeight);
        liner = new CanCarryPassengersBehaviour(maxPassengers);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return cargoShip.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return cargoShip.getCargoWeight();
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
