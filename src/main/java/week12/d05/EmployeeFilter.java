package week12.d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {


    public List<Employee> countSeniorDevs(List<Employee> employees) {

        if (isNullOrEmpty(employees)) {
            throw new IllegalArgumentException("List is cannot be null or empty");
        }

        List<Employee> seniorDevs = new ArrayList<>();

        for (Employee item: employees) {
            if (item.getSkillLevel() >= 3 && item.getSkills().contains("programming")) {
                seniorDevs.add(item);
            }
        }

        return seniorDevs;
    }

    public List<Employee> countSeniorDevsStream(List<Employee> employees) {

        if (isNullOrEmpty(employees)) {
            throw new IllegalArgumentException("List is cannot be null or empty");
        }

        List<Employee> seniorDevs;

        seniorDevs = employees.stream().filter(skill -> skill.getSkills().contains("programming") && skill.getSkillLevel() >= 3).collect(Collectors.toList());

        return seniorDevs;
    }

    private boolean isNullOrEmpty(List<Employee> employeeList) {
        return employeeList == null || employeeList.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println( new EmployeeFilter().countSeniorDevs(new ArrayList<>(Arrays.asList(
                new Employee(34, 4, "John Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(35, 4, "Jane Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(36, 4, "Jack Doe", new ArrayList<>(Arrays.asList("running", "swimming"))),
                new Employee(37, 5, "Bob Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming"))),
                new Employee(38, 2, "Jim Doe", new ArrayList<>(Arrays.asList("programming", "running", "swimming")))
        ))));

    }
}
