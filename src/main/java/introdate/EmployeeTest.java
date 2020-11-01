package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        int year;
        int month;
        int day;
        String name;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alkalmaztott neve: ");
        name = scanner.nextLine();
        System.out.println("Születési év: ");
        year = scanner.nextInt();
        System.out.println("Születési hónap: ");
        month = scanner.nextInt();
        System.out.println("Születési nap: ");
        day = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(year, month, day, name);

        System.out.println("Rögzített adatok:\n\r" + "Dolgozó neve: \t" + employee.getName() +
                "\n\rSzületési idŐ: \t" + employee.getDateOfBirth() +
                "\n\rBelépés ideje: \t" + employee.getBeginEmployment());

        System.out.println("Új név:");
        employee.setName(scanner.nextLine());
        scanner.close();

        System.out.println("Rögzített adatok:\n\r" + "Dolgozó neve: \t" + employee.getName() +
                "\n\rSzületési idŐ: \t" + employee.getDateOfBirth() +
                "\n\rBelépés ideje: \t" + employee.getBeginEmployment());
    }
}
