package week13.d04;

public class Employee {

    private final String name;

    private final int YearOfBirth;


    public Employee(String name, int yearOfBirth) {
        this.name = name;
        YearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public String getName() {
        return name;
    }
}
