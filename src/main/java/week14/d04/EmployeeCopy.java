package week14.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeCopy {


    private List<Employee> employees;

    public EmployeeCopy(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> employeeTransform() {
        return employees.stream()
                .map(Employee::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public static void main(String[] args) {
        EmployeeCopy employeeCopy = new EmployeeCopy(new ArrayList<>(Arrays.asList(new Employee("John"), new Employee("Jack"), new Employee("Jane"))));

        System.out.println(employeeCopy.getEmployees());

        System.out.println(employeeCopy.employeeTransform());

        System.out.println(employeeCopy.getEmployees());
    }
}
