package practice;

public enum CanoeType {

    RED(1D), GREEN(1.2D), BLUE(1.5D);

    private double multiplier;

    CanoeType(double multiplier) {
        this.multiplier = multiplier;
    }


    public double getMultiplier() {
        return multiplier;
    }
}
