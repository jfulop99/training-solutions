package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods{

    private CanCarryGoods cargoShip;

    public CargoShip(int maxCargoWeight) {
        cargoShip = new CanCarryGoodsBehaviour(maxCargoWeight);
    }

    @Override
    public int loadCargo(int cargoWeight) {
        return cargoShip.loadCargo(cargoWeight);
    }

    @Override
    public int getCargoWeight() {
        return cargoShip.getCargoWeight();
    }
}
