package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;


    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel < getTankCapacity() + extraCapacity - getFuel()) {
            if (fuel < super.calculateRefillAmount()) {
                super.modifyFuelAmount(fuel);
            }
            else {
                super.modifyFuelAmount(super.calculateRefillAmount());
                extraFuel = fuel - super.calculateRefillAmount();
            }
        }
    }

    public void drive(int km) {
        double fuel = km /100 * getFuelRate();
        if (fuel < getFuel() + extraFuel) {
            extraFuel -= fuel;
            if (extraFuel < 0) {
                super.modifyFuelAmount(extraFuel);
                extraFuel = 0;
            }
        }
        else {
            throw new IllegalStateException("Not enough fuel available!");
        }
    }

    public double calculateRefillAmount(){
        return super.calculateRefillAmount() + extraCapacity - extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }
}
