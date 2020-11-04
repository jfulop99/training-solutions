package debug.employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee findEmployeeByName(String name) {
        for (Employee employee: employees ) {
            if (employee.getName().startsWith(name)) { //equals helyett startwith
                return employee;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>(); // nem inicializáltam az IDEA segített
        for (Employee employee: employees) {
            names.add(employee.getName());
        }
        return names;
    }
}
