package introinheritance.employee;

public class Boss extends Employee{

    private int numberOfEmployees;
    private final static double LEADERSHIP_FACTOR = 0.1;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getSalary(){
        return super.getSalary() * (1 + numberOfEmployees * LEADERSHIP_FACTOR);
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
