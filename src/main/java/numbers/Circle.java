package numbers;

public class Circle {
    private final double pi = 3.14;
    private final int diameter;

    public Circle (int diameter){
        this.diameter = diameter;
    }

    public double perimeter(){
        return (double)diameter * pi;
    }

    public double area(){
        return Math.pow((double)diameter, 2.0) * pi / 4;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public String toString(){
        return "Diameter: " + diameter + " Perimeter: " + perimeter() + " Area: " + area();
    }
}
