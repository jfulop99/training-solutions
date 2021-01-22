package week12.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeFilterTest {

    @Test
    void countSeniorDevs() {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(34, 4, "John Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(35, 4, "Jane Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(36, 4, "Jack Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(37, 5, "Bob Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(38, 2, "Jim Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming")))
        ));

        EmployeeFilter employeeFilter = new EmployeeFilter();

        List<Employee> filtered = employeeFilter.countSeniorDevs(employees);

        System.out.println(filtered);

        assertEquals(2, filtered.size());

    }

    @Test
    void countSeniorDevsStream() {

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(34, 4, "John Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(35, 4, "Jane Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(36, 4, "Jack Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(37, 5, "Bob Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(38, 2, "Jim Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming")))
        ));

        EmployeeFilter employeeFilter = new EmployeeFilter();

        List<Employee> filtered = employeeFilter.countSeniorDevsStream(employees);

        System.out.println(filtered);

        assertEquals(2, filtered.size());

    }
}