package isahasa.fleet;

public class CanCarryGoodsBehaviour implements CanCarryGoods{

    private int cargoWeight;
    private int maxCargoWeight;

    public CanCarryGoodsBehaviour(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public int loadCargo(int cargoWeight) {
        int total = this.cargoWeight + cargoWeight;
        if (total < maxCargoWeight) {
            this.cargoWeight = total;
            return 0;
        }
        this.cargoWeight = maxCargoWeight;
        return total - maxCargoWeight;
    }

    @Override
    public int getCargoWeight() {
        return cargoWeight;
    }
}
