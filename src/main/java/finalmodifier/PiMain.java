package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator circleCalculator = new CircleCalculator();
        CylinderCalculator cylinderCalculator = new CylinderCalculator();
        System.out.println("A Pi értéke:    \t" + CircleCalculator.PI);
        System.out.println("A Kör kerülete: \t" + circleCalculator.calculatePerimeter(5.0));
        System.out.println("A Kör területe: \t" + circleCalculator.calculateArea(5.0));
        System.out.println("A Henger felszíne: \t" + cylinderCalculator.calculateSurfaceArea(5.0, 10.0));
        System.out.println("A Hneger térfogata:\t" + cylinderCalculator.calculateVolume(5.0, 10.0));
    }
}
