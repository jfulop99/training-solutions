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


    public static void main(String[] args) {
        EmployeeCopy employeeCopy = new EmployeeCopy(new ArrayList<>(Arrays.asList(new Employee("John"), new Employee("Jack"))));


        List<Employee> newList = employeeCopy.employees.stream().map(employee -> new Employee(employee.getName().toUpperCase())).collect(Collectors.toList());

        System.out.println(newList);

    }
}
