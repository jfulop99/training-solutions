package iofilestest.cheese;

import catalog.Validators;

public class Cheese {

    private final String name;
    private final double amountOfLactose;

    public Cheese(String name, double amountOfLactose) {
        if (Validators.isBlank(name)) {
            throw new IllegalArgumentException("Invalid name name = " + name);
        }
        this.name = name;
        if (amountOfLactose < 0) {
            throw new IllegalArgumentException("Invalid amount of lactose = " + amountOfLactose);
        }
        this.amountOfLactose = amountOfLactose;
    }

    public double getAmountOfLactose() {
        return amountOfLactose;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", amountOfLactose=" + amountOfLactose +
                '}';
    }
}
