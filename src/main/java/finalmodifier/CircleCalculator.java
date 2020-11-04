package finalmodifier;

public class CircleCalculator {
    final static double PI = 3.14159;

    double calculatePerimeter(double r){
        return 2.0 * r * PI;
    }
    double calculateArea(double r){
        return Math.pow(r, 2) * PI;
    }
}
