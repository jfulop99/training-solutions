package finalmodifier;

import static finalmodifier.CircleCalculator.PI;

public class CylinderCalculator {
    public double calculateVolume(double r, double h){
        return Math.pow(r, 2) * PI * h;
    }

    public double calculateSurfaceArea(double r, double h){
        return Math.pow(r, 2) * PI + 2.0 * r * PI;
    }
}
