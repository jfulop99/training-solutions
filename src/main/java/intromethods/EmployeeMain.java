package intromethods;


public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 1980, 823000);
        System.out.println(employee);
        employee.raiseSalary(150000);
        System.out.println(employee);
    }
}
