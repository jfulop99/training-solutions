package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        this.fuelRate = fuelRate;
        if (fuel > tankCapacity){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public void modifyFuelAmount(double fuel){
        this.fuel = this.fuel + fuel;
    }

    public void drive(int km) {
        double fuel = km /100 * fuelRate;
        if (fuel < this.fuel) {
            this.fuel -= fuel;
        }
        else {
            throw new IllegalStateException("Not enough fuel available!");
        }
    }

    public double calculateRefillAmount() {
        return tankCapacity - fuel;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }
}
