package debug.employee;

import java.util.ArrayList;

public class CompanyMain {

    public static void main(String[] args) {
        Company company = new Company(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            company.addEmployee(new Employee("Kovács" + i + " János", 1980+i));
        }
        System.out.println(company.listEmployeeNames());

        Employee hit = company.findEmployeeByName("Kovács5");
        if (hit != null) {
            System.out.print(hit.getName() + "\t");
            System.out.println(hit.getYearOfBirth());
        }

    }
}
