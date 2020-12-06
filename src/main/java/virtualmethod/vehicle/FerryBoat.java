package virtualmethod.vehicle;

public class FerryBoat extends Vehicle{

    public final static int MAX_CARRY_WEIGHT = 2000;

    private Car car;

    public FerryBoat(int vehicleWeight) {
        super(vehicleWeight);
    }

    @Override
    public int getGrossLoad() {
        return super.getGrossLoad() + car.getGrossLoad();
    }

    public boolean canCarry(Car car) {
        if (car != null && car.getGrossLoad() < MAX_CARRY_WEIGHT) {
            return true;
        }
        return false;
    }

    public boolean load(Car car) {
        if (car != null && car.getGrossLoad() < MAX_CARRY_WEIGHT) {
            this.car = car;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FerryBoat{" +
                "car=" + car.toString() +
                '}';
    }
}
