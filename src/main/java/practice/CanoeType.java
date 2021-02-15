package practice;

public enum CanoeType {

    RED(1), GREEN(1.2), BLUE(1.5);

    private double multiplier;

    CanoeType(double multiplier) {

    }


    public double getMultiplier() {
        return multiplier;
    }
}
