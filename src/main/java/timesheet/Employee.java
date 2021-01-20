package timesheet;

public class Employee {

    private final String firstName;

    private final String lastName;

    public Employee(String firstName, String lastName) {

        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Firstname is cannot be blank");
        }
        this.firstName = firstName;

        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Lastname is cannot be blank");
        }
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
